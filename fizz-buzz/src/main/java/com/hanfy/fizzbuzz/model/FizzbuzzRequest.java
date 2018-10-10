package com.hanfy.fizzbuzz.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class FizzbuzzRequest.
 */
public class FizzbuzzRequest {

	/** The fizzbuzz list. */
	private List<Fizzbuzz> fizzbuzzList = new ArrayList<>();

	/**
	 * Instantiates a new fizzbuzz request.
	 */
	public FizzbuzzRequest() {
		super();
	}

	/**
	 * Instantiates a new fizzbuzz request.
	 *
	 * @param fizzbuzzList the fizzbuzz list
	 */
	@JsonCreator
	public FizzbuzzRequest(
			@Valid @NotNull(message = "MISSING_REQUIRED_LIST") @NotEmpty(message = "MISSING_REQUIRED_LIST")
			@JsonProperty List<Fizzbuzz> fizzbuzzList) {
		this.fizzbuzzList = fizzbuzzList;
	}

	/**
	 * Gets the fizzbuzz list.
	 *
	 * @return the fizzbuzz list
	 */
	public List<Fizzbuzz> getFizzbuzzList() {
		return fizzbuzzList;
	}

	/**
	 * Sets the fizzbuzz list.
	 *
	 * @param fizzbuzzList the new fizzbuzz list
	 */
	public void setFizzbuzzList(List<Fizzbuzz> fizzbuzzList) {
		this.fizzbuzzList = fizzbuzzList;
	}
}
