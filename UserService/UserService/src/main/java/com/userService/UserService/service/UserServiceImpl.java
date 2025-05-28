package com.userService.UserService.service;

import com.userService.UserService.exception.ResourceNotFoundException;
import com.userService.UserService.external.service.HotelService;
import com.userService.UserService.external.service.RatingService;
import com.userService.UserService.model.Hotel;
import com.userService.UserService.model.Ratings;
import com.userService.UserService.model.User;
import com.userService.UserService.repo.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

    @Autowired
    private RatingService ratingService;

    @Override
    public User saveUser(User user) {
        return this.userRepo.save(user);
    }

    /*// getting user by id with that i am fetching ratings related to the userId and after that the hotels
    @Override
    public User getUserById(String userId) {

        User user = this.userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User with id " + userId + " is not present!!!"));

        // Fetch ratings for the user
        ResponseEntity<List<Ratings>> response = restTemplate.exchange(
                "http://RATINGSERVICE/api/ratings/getByUserId/" + user.getUserId(),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Ratings>>() {}
        );

        List<Ratings> ratingsList = response.getBody();

        // using rest template
        // Fetch hotel details for each rating
        List<Ratings> updatedRatingsList = ratingsList.stream().map(rating -> {
            ResponseEntity<Hotel> hotelResponse = restTemplate.exchange(
                    "http://HOTELSERVICE/api/hotels/get/byId/" + rating.getHotelId(),
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<Hotel>() {}
            );
            Hotel hotel = hotelResponse.getBody();
            rating.setHotel(hotel);  //  Now this will work
            return rating;
        }).collect(Collectors.toList());

        log.info("Updated Ratings List: {}", updatedRatingsList);
// Set the updated ratings list in user
        user.setRratingsList(updatedRatingsList);
       *//*

        // here i am using feign client
        List<Ratings> list = ratingsList.stream().map(ratings -> {
            Hotel hotel = hotelService.getHotel(ratings.getHotelId());
            ratings.setHotel(hotel);
            return ratings;
        }).toList();

        user.setRratingsList(list);
     *//*   return user;
    }
*/
    // use feign client here
    @Override
    public User getUserById(String userId) {
        // first find user from db
        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with id " + userId + " is not present!!!"));

        // now find the ratings by using feign client
        List<Ratings> ratings = this.ratingService.ratings(userId);
        user.setRratingsList(ratings);

        List<Ratings> list = ratings.stream().map(ratings1 -> {
            Hotel hotel = this.hotelService.getHotel(ratings1.getHotelId());
            ratings1.setHotel(hotel);
            return ratings1;
        }).toList();

        user.setRratingsList(list);
        return user;
    }
    @Override
    public List<User> getAllUser() {
        List<User> allUsers = this.userRepo.findAll();
     /*   // fetch all hotels with the help of restTemplate
        ResponseEntity<List<Hotel>> exchange = this.restTemplate.exchange(
                "http://localhost:8082/api/hotels/get-all",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Hotel>>() {
                }
        );
        List<Hotel> body = exchange.getBody();

        // fetching the ratings from the db here using rest template
        ResponseEntity<List<Ratings>> exchange1 = this.restTemplate.exchange(
                "http://localhost:8083/api/ratings/get",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Ratings>>() {
                }
        );
        List<Ratings> body1 = exchange1.getBody();
        body1.stream().*/

        return allUsers;

    }
}