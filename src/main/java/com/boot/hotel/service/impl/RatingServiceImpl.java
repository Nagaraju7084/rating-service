package com.boot.hotel.service.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.hotel.dto.RatingDto;
import com.boot.hotel.entity.Rating;
import com.boot.hotel.repository.RatingRepository;
import com.boot.hotel.service.RatingService;

@Service
public class RatingServiceImpl implements RatingService {
	
	@Autowired
	private RatingRepository ratingRepository;

	@Override
	public RatingDto createRating(RatingDto ratingDto) {
		//generate unique ratingId
		String randomUserId = UUID.randomUUID().toString();
		ratingDto.setRatingId(randomUserId);
		return entityToDto(ratingRepository.save(dtoToEntity(ratingDto)));
	}

	@Override
	public List<RatingDto> getAllRatings() {
		return ratingRepository.findAll().stream().map(
				rating -> entityToDto(rating)).collect(Collectors.toList());
	}

	@Override
	public List<RatingDto> getAllRatingsByUserId(String userId) {
		return ratingRepository.findByUserId(userId).stream().map(
				rating -> entityToDto(rating)).collect(Collectors.toList());
	}

	@Override
	public List<RatingDto> getAllRatingsByHotelId(String hotelId) {
		return ratingRepository.findByHotelId(hotelId).stream().map(
				rating -> entityToDto(rating)).collect(Collectors.toList());
	}
	
	private Rating dtoToEntity(RatingDto ratingDto) {
		Rating rating = new Rating();
		BeanUtils.copyProperties(ratingDto, rating);
		return rating;
	}
	
	private RatingDto entityToDto(Rating rating) {
		RatingDto ratingDto = new RatingDto();
		BeanUtils.copyProperties(rating, ratingDto);
		/*ratingDto.setRatingId(rating.getRatingId());
		ratingDto.setRating(rating.getRating());
		ratingDto.setFeedback(rating.getFeedback());
		ratingDto.setUserId(rating.getUserId());
		ratingDto.setHotelId(rating.getHotelId());*/
		return ratingDto;
	}

}
