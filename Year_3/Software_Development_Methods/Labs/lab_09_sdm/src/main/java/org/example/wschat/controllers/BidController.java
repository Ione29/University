package org.example.wschat.controllers;

import org.example.wschat.dto.Auction;
import org.example.wschat.dto.Bid;
import org.example.wschat.dto.BidMessage;
import org.example.wschat.storage.AuctionStorage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class BidController {
	private final SimpMessagingTemplate messagingTemplate;
	private final AuctionStorage auctionStorage;

	public BidController(SimpMessagingTemplate messagingTemplate, AuctionStorage auctionStorage) {
		this.messagingTemplate = messagingTemplate;
		this.auctionStorage = auctionStorage;
	}

	@MessageMapping("/bids")
	public void handleAuctionMessage(BidMessage message) {
		Auction auction = auctionStorage.getAuctionById(message.getAuction());
		Bid bid = new Bid(auction, message.getBidder(), message.getOffer(), message.getTime());
		if (auctionStorage.addBid(auction,bid)){
			BidMessage response = new BidMessage(bid.getId(),bid.getAuction().getId(),bid.getBidder(),bid.getOffer(),bid.getTime());
			messagingTemplate.convertAndSend("/topic/bids", response);
		}

	}
}
