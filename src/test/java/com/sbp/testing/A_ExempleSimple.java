package com.sbp.testing;

import com.sbp.testing.divers.CalculatorService;
import com.sbp.testing.divers.MathHelper;
import com.sbp.testing.divers.ToMockHelper;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class A_ExempleSimple {

	@Test
	void testOK() {
		Assert.isTrue(true,"Fonctionne");
	}

	@Test
	void testPasOK() {
		Assert.isTrue(false,"Ne Fonctionne pas ? ");
	}

	@Test
	void testAddMocked() {
		MathHelper mockMathHelper = mock(MathHelper.class);
		when(mockMathHelper.add(2, 3)).thenReturn(5);

		CalculatorService calculatorService = new CalculatorService(mockMathHelper);

		int result = calculatorService.add(2, 3);
		assertEquals(5, result);

		int forcedResult = 1 ;
		when(mockMathHelper.add(2, 3)).thenReturn(forcedResult);
		result = calculatorService.add(2, 3);
		assertEquals(forcedResult, result);
	}

	@Test
	void testAddWithSpy() {
		MathHelper realMathHelper = new MathHelper();
		MathHelper spyMathHelper = spy(realMathHelper);
		ToMockHelper mockToMockHelper = mock(ToMockHelper.class);

		CalculatorService calculatorService = new CalculatorService(spyMathHelper,mockToMockHelper);

		int result = calculatorService.add(2, 3);
		assertEquals(5, result);

		int forcedResult = 1;
		doReturn(forcedResult).when(spyMathHelper).add(2, 3);

		result = calculatorService.add(2, 3);
		assertEquals(forcedResult, result);
	}

	@Test
	void testAddWithVariousAssertions() {
		MathHelper mockMathHelper = mock(MathHelper.class);
		ToMockHelper mockToMockHelper = mock(ToMockHelper.class);

		when(mockMathHelper.add(2, 3)).thenReturn(5);

		CalculatorService calculatorService = new CalculatorService(mockMathHelper,mockToMockHelper);

		int result = calculatorService.add(2, 3);

		assertEquals(5, result, "Result should be 5");
		assertNotEquals(4, result, "Result should not be 4");
		assertTrue(result > 0, "Result should be positive");
		assertFalse(result < 0, "Result should not be negative");
		assertNotNull(result, "Result should not be null");
		assertNull(null, "Value should be null");

		assertAll(
				"Grouped Assertions",
				() -> assertEquals(5, result, "Result equals 5"),
				() -> assertNotNull(result, "Result is not null"),
				() -> assertTrue(result > 0, "Result is positive")
		);

		verify(mockMathHelper).add(2, 3);
	}

}
