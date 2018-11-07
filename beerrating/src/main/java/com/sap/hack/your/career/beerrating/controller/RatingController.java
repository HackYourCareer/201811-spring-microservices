package com.sap.hack.your.career.beerrating.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sap.hack.your.career.beerrating.entity.Rating;
import com.sap.hack.your.career.beerrating.service.RatingService;

/**
 * REST controller for {@link Rating} entity
 */
@RestController
@RequestMapping("/beer")
public class RatingController {

	private final RatingService ratingService;

	/**
	 * Injected instance of a {@link RatingService} to operate {@link Rating} entity
	 */
	@Autowired
	public RatingController(final RatingService ratingService) {
		this.ratingService = ratingService;
	}

	/**
	 * Save {@link Rating} entity in the database if such is valid
	 *
	 * @param rating data to create
	 * @param beerId of a beer to
	 */
	@PostMapping("/{beerId}")
	public void addRating(@PathVariable("beerId") final Long beerId, @RequestBody final Rating rating) {
		rating.setBeerId(beerId);
		ratingService.save(rating);
	}

	/**
	 * Get sum of all {@link Rating} in the database for given beer
	 *
	 * @param beerId of a beer with overall rating to retrieve
	 */
	@GetMapping("/{beerId}")
	public Float getOverallRating(@PathVariable("beerId") final Long beerId) {
		return ratingService.getOverallRating(beerId);
	}

	/**
	 * Removes every {@link Rating} entity with provided beer id
	 *
	 * @param beerId of a beer ratings to remove
	 */
	@DeleteMapping("/{beerId}")
	public void deleteAllRatingForBeer(@PathVariable("beerId") final Long beerId) {
		ratingService.removeByBeerId(beerId);
	}
}