package com.sbp.testing;

import com.sbp.testing.divers.CalculatorService;
import com.sbp.testing.divers.MathHelper;
import org.junit.jupiter.api.*;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

@SpringBootTest
class B_BeforeAndAfter {

	@Autowired
	private CalculatorService calculatorService;

	@Spy
	private MathHelper mathHelper;

	@BeforeAll
    static void setUp() {
		System.out.println("Starting Before ALL");
	}

	@BeforeEach
	void prepare() {
		System.out.println("Started Before One");
	}

	@AfterEach
	void tearDownOne() {
		System.out.println("Finished One");
	}

	@AfterAll
	static void clean() {
		System.out.println("Finished ALL");
	}

	@Test
	void testAdd() {
		int result = calculatorService.add(2, 3);
		assertEquals(5, result);
	}

	@Test
	void testAddForcedResult() {
		mathHelper = spy(mathHelper);
		doReturn(1).when(mathHelper).add(2, 3);
		int result = calculatorService.add(2, 3);
		assertEquals(5, result);
	}
}

