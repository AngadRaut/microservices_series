package com.hotelService.hotelservice.controller;

import com.hotelService.hotelservice.model.Hotel;
import com.hotelService.hotelservice.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {
    @Autowired
    private HotelService service;

    @PostMapping("/add")
    public ResponseEntity<?> addHotel(@RequestBody Hotel hotel){
        Hotel hotel1 = this.service.addHotel(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(hotel1);
    }
    @GetMapping("/get/byId/{id}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable("id") String hotelId){
        Hotel hotel1 = this.service.getHotelById(hotelId);
        return ResponseEntity.ok(hotel1);
    }
    @GetMapping("/get-all")
    public ResponseEntity<?> getUsers(){
        List<Hotel> allHotels = this.service.getAllHotels();
        if(allHotels.size() == 0 || allHotels.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Hotels not found");
        }else {
            return ResponseEntity.status(HttpStatus.OK).body(allHotels);
        }
    }
}