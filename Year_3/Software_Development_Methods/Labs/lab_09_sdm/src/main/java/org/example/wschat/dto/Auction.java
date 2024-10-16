package org.example.wschat.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Auction {
	static Long idCounter = 1L;
	private final Long id;
	private final String itemName;
	private final double minOffer;
	private List<Bid> bids = new ArrayList<>();
	private double currentOffer = 0;
	private final Date endTime;


	public Auction(String itemName, double minOffer, Date endTime) {
		this.itemName = itemName;
		this.minOffer = minOffer;
		this.endTime = endTime;
		this.id = idCounter++;

	}

	public String getItemName() {
		return itemName;
	}

	public double getMinOffer() {
		return minOffer;
	}

	public double getCurrentOffer() {
		return currentOffer;
	}

	public Date getEndTime() {
		return endTime;
	}

	public List<Bid> getBids() {
		return bids;
	}

	public boolean addBid(Bid bid) {
		if (bid.getOffer() < minOffer && bid.getTime().getTime() > endTime.getTime()) {
			return false;
		}
		if (bid.getOffer() > currentOffer) {
			currentOffer = bid.getOffer();
			bids.add(bid);
			return true;
		}
		return false;
	}

	public Long getId() {
		return id;
	}

	public Bid getWinner() {
		if (!bids.isEmpty()) {
			return bids.get(bids.size() - 1);
		}
		return null;
	}
}


