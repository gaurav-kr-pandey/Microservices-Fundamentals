package com.learn.ratingsdataservice.resources;

import com.learn.ratingsdataservice.models.Rating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratingsdata")
public class RatingResources {

    @RequestMapping("/{movieId}")
    public Rating getRatingResources(@PathVariable("movieId") String movieId){
        return new Rating(movieId,4);
    }
}
