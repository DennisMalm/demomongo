package com.example.demomongo.controller;

import com.example.demomongo.model.Movie;
import com.example.demomongo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    MovieService movieService;

    @RequestMapping("/create")
    public String create(@RequestBody Movie movie) {
        Movie created = movieService.create(movie);
        return created.toString();
    }
    @PostMapping("/get")
    public Movie getMovie(@RequestParam String title){
        return movieService.findByTitle(title);
    }
    @RequestMapping("/getAll")
    public List<Movie> getAll() {
        return movieService.getAll();
    }
    @PostMapping("/update")
    public Movie update(Movie movie){

        return movieService.update(movie);
    }
    @RequestMapping("/delete")
    public String delete(String title){
        movieService.delete(title);
        return "Deleted: " + title;
    }
    @RequestMapping("/deleteAll")
    public String deleteAll(){
        movieService.deleteAll();
        return "Deleted all records.";
    }


}
