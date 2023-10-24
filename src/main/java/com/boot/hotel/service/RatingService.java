package com.boot.hotel.service;

import java.util.List;

import com.boot.hotel.dto.RatingDto;

public interface RatingService {

	//create rating
	RatingDto createRating(RatingDto ratingDto);
	
	//get all ratings
	List<RatingDto> getAllRatings();
	
	//get all by userid
	List<RatingDto> getRatingByUserId(String userId);
	
	//get all by hotel
	List<RatingDto> getRatingByHotelId(String hotelId);
	
}
