package com.example.demomongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepo extends MongoRepository<Movie, String> {
}
