package com.userService.UserService.external.service;

import com.userService.UserService.model.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HotelService")
public interface HotelService {

    @GetMapping("/api/hotels/get/byId/{id}")
    public Hotel getHotel(@PathVariable("id") String hotelId);
}