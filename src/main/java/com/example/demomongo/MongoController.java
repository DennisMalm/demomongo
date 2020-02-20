package com.example.demomongo;

import com.example.demomongo.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MongoController {

    @Autowired
    MovieRepo movieRepo;

    @RequestMapping("/hello")
    public String getHello() {
        return "Hej hej";
    }

    @RequestMapping("/movies")
    public List<Movie> getMovies() {

        return movieRepo.findAll();
    }

    @PostMapping("/insert")
    public Movie insertRecord(@RequestBody Movie movie) {

        movieRepo.save(movie);
        return movie;

    }


}
