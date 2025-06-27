package com.dmx.profile.location.domain;

import com.dmx.profile.shared.domain.StringValueObject;

public final class LocationAddress extends StringValueObject {
    public LocationAddress(String value) {
        super(value);
    }

    private LocationAddress() {
        super(null);
    }
}
