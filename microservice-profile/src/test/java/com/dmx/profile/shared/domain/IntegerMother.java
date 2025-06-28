package com.dmx.profile.shared.domain;

public final class IntegerMother {
    public static Integer random(){
        return TestCreator.random().number().randomDigit();
    }
}
