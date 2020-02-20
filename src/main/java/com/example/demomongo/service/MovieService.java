package com.example.demomongo.service;

import com.example.demomongo.model.Movie;
import com.example.demomongo.repository.MovieRepo;
import com.mongodb.MongoException;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepo movieRepo;

    //  Create
    public Movie create(Movie movie) {
        return movieRepo.save(movie);
    }

    //  Retrieve
    public List<Movie> getAll() {
        return movieRepo.findAll();
    }

    public Movie findByTitle(String title) {
        return movieRepo.findByTitle(title);
    }

    //  Update operation
    public Movie update(Movie newMovie) {



        return movieRepo.findById(newMovie.getId())
                .map(oldMovie -> {
                    oldMovie.setId(newMovie.getId());
                    oldMovie.setTitle(newMovie.getTitle());
                    oldMovie.setYear(newMovie.getYear());
                    oldMovie.setCast(newMovie.getCast());

                    return movieRepo.save(newMovie);
                })
                .orElse(null);
    }

    //  Delete
    public void deleteAll() {
        movieRepo.deleteAll();
    }

    public void delete(String title) {
        Movie search = movieRepo.findByTitle(title);
        movieRepo.delete(search);
    }
}
