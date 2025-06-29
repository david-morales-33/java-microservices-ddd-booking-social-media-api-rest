package com.dmx.profile.status.domain;

import com.dmx.profile.shared.domain.UuidMother;

public final class StatusIdMother {
    public static StatusId create(String value) {
        return new StatusId(value);
    }

    public static StatusId random() {
        return new StatusId(UuidMother.random());
    }
}
