package com.example.demomongo.service;

import com.example.demomongo.model.Movie;
import com.example.demomongo.repository.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepo movieRepo;

    //  Create
    public Movie create(Movie movie){
        return movieRepo.save(movie);
    }
    //  Retrieve
    public List<Movie> getAll(){
        return movieRepo.findAll();
    }
    public Movie findByTitle(String title){
        return movieRepo.findByTitle(title);
    }
    //  Update operation
    public Movie update(Movie movie){
        Movie search = movieRepo.findMovieId(movie.getId());
        search.setTitle(movie.getTitle());
        search.setYear(movie.getYear());
        search.setCast(movie.getCast());
        return movieRepo.save(search);
    }
    //  Delete
    public void deleteAll(){
        movieRepo.deleteAll();
    }
    public void delete(String title){
        Movie search = movieRepo.findByTitle(title);
        movieRepo.delete(search);
    }
}
