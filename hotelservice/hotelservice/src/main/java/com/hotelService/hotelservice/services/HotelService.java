package com.hotelService.hotelservice.services;

import com.hotelService.hotelservice.model.Hotel;

import java.util.List;

public interface HotelService {
    public Hotel addHotel(Hotel hotel);
    public Hotel getHotelById(String hotelId);
    public List<Hotel> getAllHotels();
}
