package com.hotelService.hotelservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/staffs")
public class StaffController {
    @GetMapping("/get-all")
    public ResponseEntity<?> getStafs(){
        List<String> strings = Arrays.asList("ram","sham","sita");
        return ResponseEntity.status(HttpStatus.OK).body(strings);
    }
}
