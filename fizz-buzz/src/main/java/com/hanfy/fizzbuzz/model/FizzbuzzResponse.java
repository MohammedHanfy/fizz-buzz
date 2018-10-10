package com.hanfy.fizzbuzz.model;

import java.util.List;

/**
 * The Class FizzbuzzResponse.
 */
public class FizzbuzzResponse {

	/** The fizzbuzz game list. */
	private List<FizzbuzzGame> fizzbuzzGameList;

	/**
	 * Instantiates a new fizzbuzz response.
	 */
	public FizzbuzzResponse() {
		super();
	}

	/**
	 * Instantiates a new fizzbuzz response.
	 *
	 * @param fizzbuzzGameList the fizzbuzz game list
	 */
	public FizzbuzzResponse(List<FizzbuzzGame> fizzbuzzGameList) {
		this.fizzbuzzGameList = fizzbuzzGameList;
	}

	/**
	 * Gets the fizzbuzz game list.
	 *
	 * @return the fizzbuzz game list
	 */
	public List<FizzbuzzGame> getFizzbuzzGameList() {
		return fizzbuzzGameList;
	}

	/**
	 * Sets the fizzbuzz game list.
	 *
	 * @param fizzbuzzGameList the new fizzbuzz game list
	 */
	public void setFizzbuzzGameList(List<FizzbuzzGame> fizzbuzzGameList) {
		this.fizzbuzzGameList = fizzbuzzGameList;
	}
}
