package com.rating.Rating.services;

import com.rating.Rating.entities.Ratings;
import com.rating.Rating.repo.RatingsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingsServiceImpl implements RatingService{
    @Autowired
    private RatingsRepo repo;

    @Override
    public Ratings saveRatings(Ratings ratings) {
        return this.repo.save(ratings);
    }

    @Override
    public List<Ratings> getAllRatings() {
        return this.repo.findAll();
    }

    @Override
    public List<Ratings> getRatingsByUserId(String userId) {
        return this.repo.findByUserId(userId);
    }

    @Override
    public List<Ratings> getRatingsByHotelId(String hotelId) {
        return this.repo.findByHotelId(hotelId);
    }
}