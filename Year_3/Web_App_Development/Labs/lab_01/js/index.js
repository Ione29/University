function CheckIfGood(){
    const fullname = document.getElementById('fullname').value;
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;
    const repeatpass = document.getElementById('repeatpass').value;
    const email = document.getElementById('email').value;
    const phone = document.getElementById('phone').value;
    const emailRegex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
    const phoneRegex = /^[0-9]{9,11}$/;


    if(fullname === ""){
        alert("Please enter your name");
        return false;
    }

    if(username === ""){
        alert("Please enter your username");
        return false;
    }

    if(password === ""){
        alert("Please enter your password");
        return false;
    }

    if(repeatpass === ""){
        alert("Please enter your password again");
        return false;
    }

    if(email === ""){
        alert("Please enter your email");
        return false;
    }

    if(phone === ""){    
        alert("Please enter your phone number");
        return false;
    }

    if(!emailRegex.test(email.value)){
        alert("Please enter a valid email");
        return false;
    }

    if(!phoneRegex.test(phone.value)){
        alert("Please enter a valid phone number");
        return false;
    }

    let genderIsSelected = false;
    gender.forEach(input => {
        if(input.checked){
            genderIsSelected = true;
        }
    });

    if(!genderIsSelected){
        alert("Select a gender.");
        return false;
    }

    return true;
}

function checkPassword(){
    if(password !== repeatpass){
        alert("Passwords do not match");
        return false;
    }
}