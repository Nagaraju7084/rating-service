package com.boot.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.hotel.dto.RatingDto;
import com.boot.hotel.service.RatingService;

@RestController
@RequestMapping("/api")
public class RatingController {

	@Autowired
	private RatingService ratingService;
	
	@PostMapping("/ratings")
	public ResponseEntity<RatingDto> createRating(@RequestBody RatingDto ratingDto){
		return new ResponseEntity<RatingDto>(ratingService.createRating(ratingDto), HttpStatus.CREATED);
	}
	
	@GetMapping("/ratings")
	public ResponseEntity<List<RatingDto>> getAllRatings(){
		return new ResponseEntity<List<RatingDto>>(ratingService.getAllRatings(), HttpStatus.OK);
	}
	
	@GetMapping("/users/{userId}")
	public ResponseEntity<List<RatingDto>> getAllRatingByUserId(@PathVariable String userId){
		return new ResponseEntity<List<RatingDto>>(ratingService.getRatingByUserId(userId), HttpStatus.OK);
	}
	
	@GetMapping("/hotels/{hotelId}")
	public ResponseEntity<List<RatingDto>> getAllRatingsByHotelId(@PathVariable String hotelId){
		return new ResponseEntity<List<RatingDto>>(ratingService.getRatingByHotelId(hotelId), HttpStatus.OK);
	}
	
}
