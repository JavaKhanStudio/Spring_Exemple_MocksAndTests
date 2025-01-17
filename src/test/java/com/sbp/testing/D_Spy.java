package com.sbp.testing;

import com.sbp.testing.divers.CalculatorService;
import com.sbp.testing.divers.MathHelper;
import com.sbp.testing.divers.ToMockHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doReturn;

@SpringBootTest
public class D_Spy {

    @Spy
    private ToMockHelper toMockHelper;

    @Spy
    @InjectMocks
    private MathHelper mathHelper;

    @Spy
    @InjectMocks
    private CalculatorService calculatorService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        toMockHelper = Mockito.spy(new ToMockHelper());
        calculatorService = new CalculatorService(mathHelper);
    }

    @Test
    void contextLoads() {
        doReturn(10).when(mathHelper).addOnMock10(5);
        assertEquals(10, mathHelper.addOnMock10(5));

        doReturn(5).when(mathHelper).addOnMock10(1);
        assertEquals(5, mathHelper.addOnMock10(1));
        assertEquals(16, mathHelper.addOnMock10(6)); // Original implementation invoked

        doReturn(5).when(mathHelper).addOnMock10(anyInt());
        assertEquals(5, mathHelper.addOnMock10(6));

        doReturn(0).when(mathHelper).addOnMock20(anyInt());
        assertEquals(30, calculatorService.addOnPlus30(0));
    }
}