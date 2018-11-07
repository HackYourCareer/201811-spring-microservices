package com.sap.hack.your.career.beercatalog.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sap.hack.your.career.beercatalog.entity.Beer;

/**
 * CRUD repository for a {@link Beer} with one custom method declaration.
 * If you would like to know more about how repository works, go to:
 * {@see https://docs.spring.io/spring-data/commons/docs/current/reference/html/}
 */
@Repository
public interface BeerRepository extends CrudRepository<Beer, Long> {

	/**
	 * Returns {@link Beer} by name
	 *
	 * @param name of a beer to return
	 * @return {@link Beer} with a requested name, if such not exist null is returned instead.
	 */
	Beer findBeerByName(final String name);
}