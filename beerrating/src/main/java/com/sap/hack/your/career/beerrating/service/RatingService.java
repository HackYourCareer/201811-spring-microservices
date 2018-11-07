package com.sap.hack.your.career.beerrating.service;

import com.sap.hack.your.career.beerrating.entity.Rating;

/**
 * Service for a {@link Rating} - it is a place to write logic related to rating system - for example algorith that
 * calculate overall rating
 */
public interface RatingService {

	/**
	 * Save {@link Rating} entity in the database if such is valid
	 *
	 * @param rating data to create
	 */
	Rating save(final Rating rating);

	/**
	 * Compute the overall beer rating from all {@link Rating} for beer
	 *
	 * @param beerId of a beer with rating to compute
	 * @return overall rating for beer with requested beerId, if such not exist or have no ratings null is returned
	 * instead
	 */
	Float getOverallRating(final Long beerId);

	/**
	 * Remove all {@link Rating} by beer id
	 *
	 * @param beerId of a beer with rating to remove
	 * @return every removed {@link Rating} with a requested beerId, if such not exist null is returned instead
	 */
	Iterable<Rating> removeByBeerId(final Long beerId);
}
