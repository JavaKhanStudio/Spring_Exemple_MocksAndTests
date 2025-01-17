package com.sbp.testing.divers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MathHelper {

    private final ToMockHelper toMockHelper;

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int addOnLocalFixed(int a) {
        return a + fixedValue();
    }

    public int addOnMock10(int a) {
        return a + toMockHelper.shouldBeFixed10() ;
    }

    public int addOnMock20(int a) {
        return a + toMockHelper.shouldBeFixed20() ;
    }

    public int addOnMock30(int a) {
        return a + toMockHelper.shouldBeFixed10Plus20() ;
    }

    private int fixedValue() {
        return 5 ;
    }
}
