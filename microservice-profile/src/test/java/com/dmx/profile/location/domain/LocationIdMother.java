package com.dmx.profile.location.domain;

import com.dmx.profile.shared.domain.UuidMother;

public final class LocationIdMother {
    public static LocationId create(String value) {
        return new LocationId(value);
    }

    public static LocationId random() {
        return new LocationId(UuidMother.random());
    }
}
