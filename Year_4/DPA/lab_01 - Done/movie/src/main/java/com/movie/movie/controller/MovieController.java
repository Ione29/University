package com.movie.movie.controller;

import com.movie.movie.model.Movie;
import com.movie.movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class MovieController {

    @Autowired
    MovieRepository movieRepository;

    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> getAllMovies(@RequestParam(required = false) String title) {
        try {
            List<Movie> movies = new ArrayList<Movie>();
            if (title == null)
                movieRepository.findAll().forEach(movies::add);
            else
                movieRepository.findByTitleContaining(title).forEach(movies::add);
            if (movies.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(movies, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/movies/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable("id") String id) {
        Optional<Movie> movieData = movieRepository.findById(id);
        if (movieData.isPresent()) {
            return new ResponseEntity<>(movieData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/movies")
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
        try {
            Movie _movie = movieRepository.save(new Movie(movie.getTitle(), movie.getDescription(),
                    false));
            return new ResponseEntity<>(_movie, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/movies/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable("id") String id, @RequestBody Movie
            movie) {
        Optional<Movie> movieData = movieRepository.findById(id);
        if (movieData.isPresent()) {
            Movie _movie = movieData.get();
            _movie.setTitle(movie.getTitle());
            _movie.setDescription(movie.getDescription());
            _movie.setPublished(movie.isPublished());
            return new ResponseEntity<>(movieRepository.save(_movie), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/movies/{id}")
    public ResponseEntity<HttpStatus> deleteMovie(@PathVariable("id") String id) {
        try {
            movieRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/movies")
    public ResponseEntity<HttpStatus> deleteAllMovies() {
        try {
            movieRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/movies/published")
    public ResponseEntity<List<Movie>> findByPublished() {
        try {
            List<Movie> movies = movieRepository.findByPublished(true);
            if (movies.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(movies, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}