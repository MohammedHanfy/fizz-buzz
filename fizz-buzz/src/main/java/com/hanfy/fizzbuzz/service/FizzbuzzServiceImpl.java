package com.hanfy.fizzbuzz.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hanfy.fizzbuzz.model.FizzbuzzGame;
import com.hanfy.fizzbuzz.model.FizzbuzzRequest;
import com.hanfy.fizzbuzz.model.FizzbuzzResponse;

/**
 * The Class FizzbuzzServiceImpl.
 */
@Service
public class FizzbuzzServiceImpl implements FizzbuzzService {

	public FizzbuzzServiceImpl() {
		super();
	}

	@Override
	public FizzbuzzResponse play(final FizzbuzzRequest fizzbuzzRequest) {

		FizzbuzzResponse fizzbuzzResponse = new FizzbuzzResponse();
		List<FizzbuzzGame> fizzbuzzGameList = new ArrayList<>();

		fizzbuzzRequest.getFizzbuzzList().stream().forEach(fizzbuzz -> {

			Integer number = fizzbuzz.getNumber();

			FizzbuzzGame fizzbuzzGame = new FizzbuzzGame(number);
			
			StringBuilder result = new StringBuilder();

			if (number % 3 == 0) {
				result.append("Fizz");
			}
			if (number % 5 == 0) {
				result.append("Buzz");
			}

			if (result.toString().isEmpty()) {
				fizzbuzzGame.setResult(number.toString());
			} else {
				fizzbuzzGame.setResult(result.toString());
			}
			
			fizzbuzzGameList.add(fizzbuzzGame);
		});
		
		fizzbuzzResponse.setFizzbuzzGameList(fizzbuzzGameList);

		return fizzbuzzResponse;
	}
}
