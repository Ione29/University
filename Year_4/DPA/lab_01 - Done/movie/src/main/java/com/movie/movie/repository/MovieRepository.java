package com.movie.movie.repository;

import java.util.List;
import com.movie.movie.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
public interface MovieRepository extends MongoRepository<Movie, String> {
    List<Movie> findByTitleContaining(String title);
    List<Movie> findByPublished(boolean published);
}
