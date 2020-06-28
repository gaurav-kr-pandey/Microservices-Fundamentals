package com.learn.moviecatalogservice.resources;

import com.learn.moviecatalogservice.models.CatalogItem;
import com.learn.moviecatalogservice.models.Movie;
import com.learn.moviecatalogservice.models.Rating;
import com.learn.moviecatalogservice.models.UserRatings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalogs(@PathVariable("userId") String userId){
        UserRatings ratings = restTemplate.getForObject("http://ratings-data-service/ratingsdata/user/"+userId,UserRatings.class);
        return ratings.getRatings().stream().map(rating -> {
            Movie movie = restTemplate.getForObject("http://movie-info-service/movies/"+rating.getMovieId(),Movie.class);
            return new CatalogItem(movie.getName(),movie.getMovieId().toString(),4);
        }).collect(Collectors.toList());
    }
}
