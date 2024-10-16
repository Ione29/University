package org.example.wschat.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Setter
@Getter
public class AuctionMessage {

   Long id;
   String itemName;
   double minOffer;
   Date endTime;
   String winner = null;
    //getters and setters

    public AuctionMessage(Long id, String itemName, double minOffer, Date endTime)
    {
        this.id = id;
        this.itemName = itemName;
        this.minOffer = minOffer;
        this.endTime = endTime;
    }


}
