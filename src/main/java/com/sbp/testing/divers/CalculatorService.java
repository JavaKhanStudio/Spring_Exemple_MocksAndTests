package com.sbp.testing.divers;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CalculatorService {

    private final MathHelper mathHelper;

    public int add(int a, int b) {
        return mathHelper.add(a, b);
    }

    public int addOnPlus30(int a) {
        return mathHelper.addOnMock30(a) ;
    }
}
