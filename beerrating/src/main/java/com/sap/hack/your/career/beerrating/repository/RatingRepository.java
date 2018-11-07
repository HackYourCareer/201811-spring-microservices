package com.sap.hack.your.career.beerrating.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sap.hack.your.career.beerrating.entity.Rating;

/**
 * CRUD repository for a {@link Rating} with two custom method declaration.
 * If you would like to know more about how repository works, go to:
 * {@see https://docs.spring.io/spring-data/commons/docs/current/reference/html/}
 */
@Repository
public interface RatingRepository extends CrudRepository<Rating, Long> {
	/**
	 * Returns all {@link Rating} by beer id
	 *
	 * @param beerId of a beer with rating to retrieve
	 * @return every {@link Rating} with a requested beerId, if such not exist null is returned instead
	 */
	Iterable<Rating> findAllByBeerId(final Long beerId);

	/**
	 * Remove all {@link Rating} by beer id
	 *
	 * @param beerId of a beer with rating to remove
	 * @return every removed {@link Rating} with a requested beerId, if such not exist null is returned instead
	 */
	@Transactional
	Iterable<Rating> removeByBeerId(final Long beerId);
}