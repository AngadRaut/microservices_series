package com.hotelService.hotelservice.services;

import com.hotelService.hotelservice.exception.ResourceNotFoundException;
import com.hotelService.hotelservice.model.Hotel;
import com.hotelService.hotelservice.repo.HotelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService{
    @Autowired
    private HotelRepo hotelRepo;

    @Override
    public Hotel addHotel(Hotel hotel) {
        return this.hotelRepo.save(hotel);
    }

    @Override
    public Hotel getHotelById(String hotelId) {
        return this.hotelRepo.findById(hotelId).orElseThrow(()->new ResourceNotFoundException("hotel with id :"+hotelId+" is not present in records!!"));
    }

    @Override
    public List<Hotel> getAllHotels() {
        return this.hotelRepo.findAll();
    }
}
