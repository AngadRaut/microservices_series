package com.hotelService.hotelservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "hotel_service")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JsonProperty("hotelId")
    private String hotelId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("location")
    private String location;

    @JsonProperty("about")
    private String about;

    public Hotel() {}

    public Hotel(String hotelId, String name, String location, String about) {
        this.hotelId = hotelId;
        this.name = name;
        this.location = location;
        this.about = about;
    }

    public String getHotelId() { return hotelId; }
    public void setHotelId(String hotelId) { this.hotelId = hotelId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getAbout() { return about; }
    public void setAbout(String about) { this.about = about; }

   /* @Override
    public String toString() {
        return "Hotel{" +
                "hotelId='" + hotelId + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", about='" + about + '\'' +
                '}';
    }*/
}
