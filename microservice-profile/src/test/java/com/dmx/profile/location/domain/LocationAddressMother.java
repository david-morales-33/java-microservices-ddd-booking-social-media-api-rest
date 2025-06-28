package com.dmx.profile.location.domain;

import com.dmx.profile.shared.domain.WordMother;

public final class LocationAddressMother {
    public static LocationAddress create(String value) {
        return new LocationAddress(value);
    }

    public static LocationAddress random() {
        return new LocationAddress(WordMother.random());
    }
}
