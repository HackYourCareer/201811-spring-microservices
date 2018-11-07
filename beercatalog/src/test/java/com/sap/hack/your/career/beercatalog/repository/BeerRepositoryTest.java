package com.sap.hack.your.career.beercatalog.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sap.hack.your.career.beercatalog.entity.Beer;

/**
 * Simple test to test {@link BeerRepository}
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class BeerRepositoryTest {

	/**
	 * Injected instance of {@link BeerRepository}
	 */
	@Autowired
	private BeerRepository beerRepository;

	/**
	 * Creates {@link Beer} entity and persist it to the database
	 */
	@Test
	public void addBeer() {
		final Beer beer = new Beer();

		beer.setName("foo");
		beer.setIbu(10);
		beer.setAlcoholContent(1.0f);

		beerRepository.save(beer);
	}
}