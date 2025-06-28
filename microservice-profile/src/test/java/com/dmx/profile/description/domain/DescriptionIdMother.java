package com.dmx.profile.description.domain;

import com.dmx.profile.shared.domain.UuidMother;

public final class DescriptionIdMother {
    public static DescriptionId create(String value) {
        return new DescriptionId(value);
    }
    public static DescriptionId random() {
        return new DescriptionId(UuidMother.random());
    }
}
