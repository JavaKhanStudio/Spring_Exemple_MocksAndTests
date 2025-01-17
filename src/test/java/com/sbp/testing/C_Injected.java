package com.sbp.testing;

import com.sbp.testing.divers.CalculatorService;
import com.sbp.testing.divers.MathHelper;
import org.junit.jupiter.api.Test;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class C_Injected {

	@Spy
	private CalculatorService calculatorService;

	@Spy
	private MathHelper mathHelper;



	@Test
	void contextLoads() {

		


	}

}
