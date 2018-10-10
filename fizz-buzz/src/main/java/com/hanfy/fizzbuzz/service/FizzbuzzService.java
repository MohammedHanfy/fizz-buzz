package com.hanfy.fizzbuzz.service;

import com.hanfy.fizzbuzz.model.FizzbuzzRequest;
import com.hanfy.fizzbuzz.model.FizzbuzzResponse;

/**
 * The Interface FizzbuzzService.
 */
public interface FizzbuzzService {

	/**
	 * Play.
	 *
	 * @param fizzbuzzRequest the fizzbuzz request
	 * @return the fizzbuzz response
	 */
	FizzbuzzResponse play(final FizzbuzzRequest fizzbuzzRequest);
}
