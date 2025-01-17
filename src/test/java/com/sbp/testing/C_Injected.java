package com.sbp.testing;

import com.sbp.testing.divers.CalculatorService;
import com.sbp.testing.divers.MathHelper;
import com.sbp.testing.divers.ToMockHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doReturn;

@SpringBootTest
class C_Injected {

	@Mock
	private MathHelper mathHelper;

	@Autowired
	private ToMockHelper toMockHelper;

	@InjectMocks
	private CalculatorService calculatorService;

	@Autowired
	private CalculatorService calculatorServiceWired;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void contextLoads() {
		doReturn(10).when(mathHelper).addOnMock10(5);
		assertEquals(10, mathHelper.addOnMock10(5));

		doReturn(5).when(mathHelper).addOnMock10(1);
		assertEquals(5, mathHelper.addOnMock10(1));
		assertEquals(0, mathHelper.addOnMock10(6));

		doReturn(5).when(mathHelper).addOnMock10(anyInt());
		assertEquals(5, mathHelper.addOnMock10(6));


		doReturn(0).when(mathHelper).addOnMock20(anyInt());
		assertEquals(0, calculatorService.addOnPlus30(0));
	}
}