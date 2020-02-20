package com.example.demomongo.repository;

import com.example.demomongo.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovieRepo extends MongoRepository<Movie, String> {
    Movie findByTitle(String title);
    Movie findMovieId(String id);
}
