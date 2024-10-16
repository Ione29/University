package org.example.wschat.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
public class Bid {
	private static Long idCounter = 1L;
	private final Long id;
	private final Auction auction;
	private final String bidder;
	private final Double offer;
	private final Date time;

	public Bid(Auction auction, String bidder, Double offer, Date time){
        this.auction = auction;
        this.bidder = bidder;
        this.offer = offer;
        this.time = time;
		this.id = idCounter++;
    }




}
