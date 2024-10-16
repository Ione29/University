package org.example.wschat.controllers;

import org.example.wschat.dto.AuctionMessage;
import org.example.wschat.storage.AuctionStorage;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class WebSocketMessageScheduler {
    private final SimpMessagingTemplate messagingTemplate;
    private final AuctionStorage auctionStorage;
    public WebSocketMessageScheduler(SimpMessagingTemplate messagingTemplate, AuctionStorage auctionStorage) {
        this.messagingTemplate = messagingTemplate;
        this.auctionStorage = auctionStorage;
    }
    @Scheduled(fixedDelay = 1000)
    public void sendMessageToWebSocketClients() {
        auctionStorage.getAll().forEach(auction -> {
           if (auction.getEndTime().getTime() < System.currentTimeMillis()) {
               AuctionMessage response = new AuctionMessage(auction.getId(), auction.getItemName(), auction.getMinOffer(), auction.getEndTime());
               if (auction.getBids().isEmpty()) {
                   response.setWinner("No bids");
               } else {
                   response.setWinner(auction.getBids().get(auction.getBids().size() - 1).getBidder());
               }
               messagingTemplate.convertAndSend("/topic/auctions.win", response);
               auctionStorage.removeAuction(auction);
       // messagingTemplate.convertAndSend("/topic/heartbeat", "Hello from server");
             }
          });
    }
}
