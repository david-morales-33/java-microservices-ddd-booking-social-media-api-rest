package com.dmx.profile.shared.domain;

public final class FloatMother {
    public static Float random() {
        return (float) TestCreator.random().number().numberBetween(0, 100) / 100;
    }
}
