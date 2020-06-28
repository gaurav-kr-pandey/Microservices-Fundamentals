package com.learn.ratingsdataservice.resources;

import com.learn.ratingsdataservice.models.Rating;
import com.learn.ratingsdataservice.models.UserRatings;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratingsdata")
public class RatingResources {

    @RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId){
        return new Rating(movieId,4);
    }

    @RequestMapping("/user/{userId}")
    public UserRatings getUserRatings(@PathVariable("userId") String userId){
        return new UserRatings(Arrays.asList(
                new Rating("1234",4),
                new Rating("4567",5)
        ));
    }
}
