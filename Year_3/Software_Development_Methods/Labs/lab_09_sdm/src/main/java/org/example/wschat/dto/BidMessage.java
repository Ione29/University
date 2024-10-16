package org.example.wschat.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class BidMessage {
    private final Long id;
    private final Long auction;
    private final String bidder;
    private final Double offer;
    private final Date time;
}
