package com.dmx.profile.shared.domain;

import com.github.javafaker.Faker;

public final class EnumMother {
    public static <T extends Enum<?>> T random(Class<T> enumClass) {
        T[] enumValues = enumClass.getEnumConstants();
        return enumValues[Faker.instance().random().nextInt(enumValues.length)];
    }
}
