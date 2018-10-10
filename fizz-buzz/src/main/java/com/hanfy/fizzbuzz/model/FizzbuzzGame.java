package com.hanfy.fizzbuzz.model;

/**
 * The Class FizzbuzzGame.
 */
public class FizzbuzzGame extends Fizzbuzz {	

	/** The result. */
	private String result;

	/**
	 * Instantiates a new fizzbuzz game.
	 *
	 * @param number the number
	 */
	public FizzbuzzGame(Integer number) {
		super(number);
	}

	/**
	 * Instantiates a new fizzbuzz game.
	 *
	 * @param number the number
	 * @param result the result
	 */
	public FizzbuzzGame(Integer number, String result) {
		super(number);
		this.result = result;
	}

	/**
	 * Gets the result.
	 *
	 * @return the result
	 */
	public String getResult() {
		return result;
	}

	/**
	 * Sets the result.
	 *
	 * @param result the new result
	 */
	public void setResult(String result) {
		this.result = result;
	}
}
