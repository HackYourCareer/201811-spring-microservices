package com.sap.hack.your.career.beerrating.service.impl;

import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sap.hack.your.career.beerrating.entity.Rating;
import com.sap.hack.your.career.beerrating.repository.RatingRepository;
import com.sap.hack.your.career.beerrating.service.RatingService;

/**
 * Service for a {@link Rating} - it is a place to write logic related to rating system - for example algorith that
 * calculate overall rating
 */
@Service
public class RatingServiceImpl implements RatingService {

	private final RatingRepository ratingRepository;

	/**
	 * Injected instance of a {@link RatingRepository} to operate {@link Rating} entity
	 */
	@Autowired
	public RatingServiceImpl(final RatingRepository ratingRepository) {
		this.ratingRepository = ratingRepository;
	}

	/**
	 * Save {@link Rating} entity in the database if such is valid
	 *
	 * @param rating data to create
	 */
	@Override
	public Rating save(final Rating rating) {
		return ratingRepository.save(rating);
	}

	/**
	 * Compute the overall beer rating from all {@link Rating} for beer
	 *
	 * @param beerId of a beer with rating to compute
	 * @return overall rating for beer with requested beerId, if such not exist or have no ratings null is returned
	 * instead
	 */
	@Override
	public Float getOverallRating(final Long beerId) {
		final Iterable<Rating> beerRatings = ratingRepository.findAllByBeerId(beerId);
		final double numberOfRatings = StreamSupport.stream(beerRatings.spliterator(), false).count();

		double sumOfRatings = 0;
		for (final Rating rating : beerRatings) {
			sumOfRatings += rating.getRating();
		}
		return (float) (sumOfRatings / numberOfRatings);
	}

	/**
	 * Remove all {@link Rating} by beer id
	 *
	 * @param beerId of a beer with rating to remove
	 * @return every removed {@link Rating} with a requested beerId, if such not exist null is returned instead
	 */
	@Override
	public Iterable<Rating> removeByBeerId(final Long beerId) {
		return ratingRepository.removeByBeerId(beerId);
	}
}
