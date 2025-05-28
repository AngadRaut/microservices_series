package com.rating.Rating.services;

import com.rating.Rating.entities.Ratings;

import java.util.List;

public interface RatingService {
    Ratings saveRatings(Ratings ratings);
    List<Ratings> getAllRatings();
    List<Ratings> getRatingsByUserId(String userId);
    List<Ratings> getRatingsByHotelId(String hotelId);
}
