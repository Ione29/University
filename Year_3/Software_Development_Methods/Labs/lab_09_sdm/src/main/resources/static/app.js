let username = null;
let socket = null;
let stompClient = null;
let auctionList = [];

function login() {
    const usernameInput = document.getElementById('usernameInput');
    username = usernameInput.value.trim();
    if (username) {
        document.getElementById('loginForm').style.display = 'none';
        if (username === 'admin') {
            console.log("Admin login");
            document.getElementById('addAuction').style.display = 'block';
        }
        else {
            document.getElementById('auctions').style.display = 'block';
        }
        console.log("Calling connect");
        connect();
    }
}

function connect() {
    socket = new SockJS('/auctions');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/auctions', function (message) {
            showAuction(JSON.parse(message.body));
        });
        stompClient.subscribe('/topic/auctions.win', function (message) {
                showAuctionWin(JSON.parse(message.body));
        });
        stompClient.subscribe('/topic/bids', function (message) {
            showBid(JSON.parse(message.body));
        });
        stompClient.subscribe('/topic/heartbeat', function (message) {
            console.log("Ping: " + message.body);
        });

    },
        function (error) {
            console.log('Connection error: ' + error);
            setTimeout(connect, 5000);
        });
}



function addAuction() {
    const inputProductName = document.getElementById('auctionNameInput');
    const inputProductPrice = document.getElementById('auctionPriceInput');
    const inputExpirationTime = document.getElementById('auctionEndDateInput');

    const product = {
        id: null,
        itemName: inputProductName.value.trim(),
        minOffer: inputProductPrice.value.trim(),
        endTime: Date.parse(inputExpirationTime.value.trim())
    };
    console.log(JSON.stringify(product));
    if (product.itemName && product.minOffer && product.endTime) {
        stompClient.send("/app/auctions", {}, JSON.stringify(product));
        inputProductName.value = '';
        inputProductPrice.value = '';
        inputExpirationTime.value = '';
    }
}

function showAuction(message) {
    const messageArea = document.getElementById('auctionsList');
    const messageElement = document.createElement('li');
    messageElement.setAttribute('id', "auc"+message.id);
    auctionList.push(message);
    messageElement.appendChild(document.createTextNode(message.id + ': '+message.itemName + ' ' + message.minOffer + ' ' + message.endTime));
    messageArea.appendChild(messageElement);
        const bidArea = document.createElement('ul');
        bidArea.setAttribute('id', "bid"+message.id);
        messageElement.appendChild(bidArea);
}

function showAuctionWin(message) {
    const messageArea = document.getElementById('auctionsList');
    const messageElement = document.getElementById("auc"+message.id);
    if (message.winner!=null){
        const winArea = document.createElement('p');
        winArea.appendChild(document.createTextNode('Winner: '+message.winner));
        messageElement.appendChild(winArea);
    }
}

function showBid(message) {

    const bidArea = document.getElementById('bid'+message.auction);
    const bidElement = document.createElement('li');
    bidElement.appendChild(document.createTextNode(message.bidder + ' ' + message.offer));
    bidArea.appendChild(bidElement);
}

document.getElementById('loginButton').addEventListener('click', function (e) {
    e.preventDefault();
    login();
});

document.getElementById('createAuctionButton').addEventListener('click', function (e) {
    e.preventDefault();
    addAuction();

});

document.getElementById("sendBidButton").addEventListener("click",function (e) {
    e.preventDefault();
    console.log("sendBidButton clicked");
    const inputBid = document.getElementById('bidIDInput');
    const priceBid = document.getElementById('bidAmountInput');

    const bid = {
        id: null,
        auction: inputBid.value.trim(),
        offer: priceBid.value.trim(),
        time: new Date().getTime(),
        bidder: username
    };
    if (bid.auction && bid.offer && bid.bidder) {
        stompClient.send("/app/bids", {}, JSON.stringify(bid));
        inputBid.value = '';
        priceBid.value = '';
}
})
// document.getElementById('messageForm').addEventListener('submit', function (e) {
//     e.preventDefault();
//     sendMessage();
// });
setInterval(function () {
    const currentTime = new Date().getTime();
    auctionList.forEach(auction => {
        const expirationTime = new Date(auction.expirationTime).getTime();
        if (expirationTime < currentTime) {
            document.getElementById("auc"+auction.id).remove();
            auctionList = auctionList.filter(auc => auc.id !== auction.id);
        }

    })}, 1000);
