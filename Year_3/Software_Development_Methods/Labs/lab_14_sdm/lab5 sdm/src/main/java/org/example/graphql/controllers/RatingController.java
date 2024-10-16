package org.example.graphql.controllers;

import org.example.graphql.domain.Buyer;
import org.example.graphql.domain.Rating;
import org.example.graphql.services.BuyerService;
import org.example.graphql.services.RatingService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class RatingController {
    private final RatingService ratingService;
    private final BuyerService buyerService;

    public RatingController(RatingService ratingService, BuyerService buyerService) {
        this.ratingService = ratingService;
        this.buyerService = buyerService;
    }

    @QueryMapping
    public List<Rating> allRatings() {
        return ratingService.getAllRatings();
    }

    @QueryMapping
    public List<Buyer> allBuyers() {
        return buyerService.getAllBuyers();
    }

    @QueryMapping
    public Rating ratingById(@Argument Long id) {
        return ratingService.getRatingById(id).orElse(null);
    }

    @QueryMapping
    public Buyer buyerById(@Argument Long id) {
        return buyerService.getBuyerById(id).orElse(null);
    }
}
