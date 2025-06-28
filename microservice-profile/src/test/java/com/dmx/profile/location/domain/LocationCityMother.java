package com.dmx.profile.location.domain;

import com.dmx.profile.shared.domain.WordMother;

public final class LocationCityMother {
    public static LocationCity create(String value) {
        return new LocationCity(value);
    }

    public static LocationCity random() {
        return new LocationCity(WordMother.random());
    }
}
