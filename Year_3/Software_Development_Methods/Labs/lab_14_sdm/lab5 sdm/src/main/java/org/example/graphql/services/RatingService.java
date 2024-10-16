package org.example.graphql.services;

import jakarta.transaction.Transactional;
import org.example.graphql.domain.Rating;
import org.example.graphql.repositories.RatingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatingService {
    private final RatingRepository ratingRepository;

    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    public Optional<Rating> getRatingById(Long id) {
        return ratingRepository.findById(id);
    }

    @Transactional
    public Rating saveRating(Rating Rating) {
        return ratingRepository.save(Rating);
    }

    @Transactional
    public void deleteRating(Long id) {
        ratingRepository.deleteById(id);
    }
}
