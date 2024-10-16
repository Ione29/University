package org.example.wschat.storage;

import org.example.wschat.dto.Auction;
import org.example.wschat.dto.Bid;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class AuctionStorage {

    private final List<Auction> auctions = Collections.synchronizedList(new ArrayList<>());

    public void addAuction(Auction auction) {
        auctions.add(auction);
    }

    public boolean addBid(Auction auction, Bid bid){
       return auction.addBid(bid);

    }

    public Auction getAuctionById(Long id){
        for (Auction auction : auctions) {
            if (auction.getId().equals(id)) {
                return auction;
            }
        }
        return null;
    }

    public List<Auction> getAll(){
        return auctions;
    }

    public void removeAuction(Auction auction) {
        auctions.remove(auction);
    }
}
