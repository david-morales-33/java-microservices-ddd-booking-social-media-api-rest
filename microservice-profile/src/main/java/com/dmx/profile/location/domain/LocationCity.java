package com.dmx.profile.location.domain;

import com.dmx.profile.shared.domain.StringValueObject;

public final class LocationCity extends StringValueObject {
    public LocationCity(String value) {
        super(value);
    }

    private LocationCity() {
        super(null);
    }
}
