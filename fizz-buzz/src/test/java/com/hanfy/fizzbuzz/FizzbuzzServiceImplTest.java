package com.hanfy.fizzbuzz;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hanfy.fizzbuzz.model.Fizzbuzz;
import com.hanfy.fizzbuzz.model.FizzbuzzRequest;
import com.hanfy.fizzbuzz.model.FizzbuzzResponse;
import com.hanfy.fizzbuzz.service.FizzbuzzServiceImpl;


@RunWith(SpringRunner.class)
@SpringBootTest
public class FizzbuzzServiceImplTest {

	@Mock
	FizzbuzzRequest fizzbuzzRequest;
	
	@Mock
	FizzbuzzResponse fizzbuzzResponse;
	
	@InjectMocks
	private FizzbuzzServiceImpl fizzbuzzServiceImpl;
	
	@Before
	public void setupMock() {
		this.fizzbuzzServiceImpl = new FizzbuzzServiceImpl();
	}

	@Test
	public void playTest() {

		List<Fizzbuzz> fizzbuzzList = new ArrayList<>();
		fizzbuzzList.add(new Fizzbuzz(1));
		fizzbuzzList.add(new Fizzbuzz(5));
		fizzbuzzList.add(new Fizzbuzz(9));
		fizzbuzzList.add(new Fizzbuzz(15));
		Mockito.doReturn(fizzbuzzList).when(fizzbuzzRequest).getFizzbuzzList();

		fizzbuzzResponse = fizzbuzzServiceImpl.play(fizzbuzzRequest);
		
		assertThat(fizzbuzzResponse.getFizzbuzzGameList().get(0).getResult()).isEqualTo("1");
		assertThat(fizzbuzzResponse.getFizzbuzzGameList().get(1).getResult()).isEqualTo("Buzz");
		assertThat(fizzbuzzResponse.getFizzbuzzGameList().get(2).getResult()).isEqualTo("Fizz");
		assertThat(fizzbuzzResponse.getFizzbuzzGameList().get(3).getResult()).isEqualTo("FizzBuzz");
	}
}
