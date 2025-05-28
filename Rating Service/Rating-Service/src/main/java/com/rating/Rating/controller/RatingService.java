package com.rating.Rating.controller;

import com.rating.Rating.entities.Ratings;
import com.rating.Rating.services.RatingsServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/ratings")
public class RatingService {
    private static final Logger log = LoggerFactory.getLogger(LoggerFactory.class);
    @Autowired
    private RatingsServiceImpl ratingsService;

    @PostMapping("/add")
    public ResponseEntity<?> addRatings(@RequestBody Ratings ratings){
        Ratings ratings1 = this.ratingsService.saveRatings(ratings);
        return ResponseEntity.status(HttpStatus.CREATED).body("Ratings saved successfully!!!"+ratings1);
    }

    @GetMapping("/get")
    public ResponseEntity<?> getRatings() {
        List<Ratings> allRatings = this.ratingsService.getAllRatings();
        return ResponseEntity.status(HttpStatus.OK).body(allRatings);
    }

    @GetMapping("/getByUserId/{id}")
    public ResponseEntity<?> getRatingsByUserId(@PathVariable("id") String userId) {
        List<Ratings> ratingsByUserId = ratingsService.getRatingsByUserId(userId);
        if (ratingsByUserId.isEmpty()) {
            return ResponseEntity.ok(Collections.emptyList()); // Returns []
        }
        log.info("{}:",ratingsByUserId);
        return ResponseEntity.status(HttpStatus.OK).body(ratingsByUserId);
    }

    @GetMapping("/getByHotelId/{id}")
    public ResponseEntity<?> getRatingsByHotelId(@PathVariable("id") String hotelId) {
        List<Ratings> ratingsByHotelId = ratingsService.getRatingsByUserId(hotelId);
        return ResponseEntity.status(HttpStatus.OK).body(ratingsByHotelId);
    }
}