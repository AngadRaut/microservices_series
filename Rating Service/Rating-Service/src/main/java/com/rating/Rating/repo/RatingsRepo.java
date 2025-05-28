package com.rating.Rating.repo;

import com.rating.Rating.entities.Ratings;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingsRepo extends MongoRepository<Ratings,String> {
    public List<Ratings> findByUserId(String userId);
    public List<Ratings> findByHotelId(String hotelId);
}