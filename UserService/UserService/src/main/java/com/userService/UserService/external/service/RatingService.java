package com.userService.UserService.external.service;

import com.userService.UserService.model.Ratings;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "RatingService")
public interface RatingService {

    // get the ratings
    @GetMapping("/api/ratings/getByUserId/{id}")
    public List<Ratings> ratings(@PathVariable("id") String userId);

}