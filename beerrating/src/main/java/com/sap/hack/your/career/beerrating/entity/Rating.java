package com.sap.hack.your.career.beerrating.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

/**
 * Simple entity with validation of fields
 */
@Entity
public class Rating {

	@Id
	@GeneratedValue
	private Long id;

	private Long beerId;

	@NotNull
	@Range(min = 1, max = 5)
	private Integer rating;

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public Long getBeerId() {
		return beerId;
	}

	public void setBeerId(final Long beerId) {
		this.beerId = beerId;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(final Integer rating) {
		this.rating = rating;
	}
}