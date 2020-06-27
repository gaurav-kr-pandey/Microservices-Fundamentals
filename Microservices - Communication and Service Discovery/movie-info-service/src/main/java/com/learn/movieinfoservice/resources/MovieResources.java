package com.learn.movieinfoservice.resources;

import com.learn.movieinfoservice.models.Movie;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieResources {

    @RequestMapping("/{movieId}")
    public Movie getResouces(@PathVariable("movieId") Integer movieId){
        return new Movie(movieId,"Test Name.");
    }
}
