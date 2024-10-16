package org.example.wschat.controllers;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.example.wschat.dto.Auction;
import org.example.wschat.dto.AuctionMessage;
import org.example.wschat.storage.AuctionStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.time.Instant;
import java.sql.Date;
import java.util.logging.Logger;

@Controller
public class AuctionController {
    private final SimpMessagingTemplate messagingTemplate;
    private final AuctionStorage auctionStorage;

    public AuctionController(SimpMessagingTemplate messagingTemplate, AuctionStorage auctionStorage) {
        this.messagingTemplate = messagingTemplate;
        this.auctionStorage = auctionStorage;
    }

    @MessageMapping("/auctions")
    public void handleAuctionMessage(AuctionMessage message) {

        Auction auction = new Auction(message.getItemName(), message.getMinOffer(), message.getEndTime());
        auctionStorage.addAuction(auction);
        AuctionMessage response = new AuctionMessage(auction.getId(), auction.getItemName(), auction.getMinOffer(), auction.getEndTime());
        messagingTemplate.convertAndSend("/topic/auctions", response);
    }
}
