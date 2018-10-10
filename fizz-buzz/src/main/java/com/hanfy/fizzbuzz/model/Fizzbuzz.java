package com.hanfy.fizzbuzz.model;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class Fizzbuzz.
 */
public class Fizzbuzz {

	/** The number. */
	private Integer number;
	
	/**
	 * Instantiates a new fizzbuzz.
	 */
	public Fizzbuzz() {
		super();
	}

	/**
	 * Instantiates a new fizzbuzz.
	 *
	 * @param number the number
	 */
	@JsonCreator
	public Fizzbuzz(@NotNull @JsonProperty Integer number) {
		this.number = number;
	}

	/**
	 * Gets the number.
	 *
	 * @return the number
	 */
	public Integer getNumber() {
		return number;
	}

	/**
	 * Sets the number.
	 *
	 * @param number the new number
	 */
	public void setNumber(Integer number) {
		this.number = number;
	}
}
