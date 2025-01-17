package com.sbp.testing.divers;

import org.springframework.stereotype.Component;

@Component
public class ToMockHelper {

    public int shouldBeFixed10() {
        return 10 ;
    }

    public int shouldBeFixed20() {
        return 20 ;
    }

    public int shouldBeFixed10Plus20() {
        return shouldBeFixed10() + shouldBeFixed20() ;
    }

}