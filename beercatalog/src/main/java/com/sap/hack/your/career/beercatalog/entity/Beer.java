package com.sap.hack.your.career.beercatalog.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Range;

/**
 * Simple entity with validation of fields
 */
@Entity
public class Beer {

	@Id
	@GeneratedValue
	private Long id;

	@NotBlank
	private String name;
	private String description;

	@Range(min = 0, max = 100)
	private Float alcoholContent;

	@Min(0)
	@Max(100)
	private Integer ibu;

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	public Float getAlcoholContent() {
		return alcoholContent;
	}

	public void setAlcoholContent(final Float alcoholContent) {
		this.alcoholContent = alcoholContent;
	}

	public Integer getIbu() {
		return ibu;
	}

	public void setIbu(final Integer ibu) {
		this.ibu = ibu;
	}
}