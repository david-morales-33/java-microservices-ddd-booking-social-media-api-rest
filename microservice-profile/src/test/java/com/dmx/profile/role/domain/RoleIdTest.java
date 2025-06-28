package com.dmx.profile.role.domain;

import com.dmx.profile.shared.domain.UuidMother;

public final class RoleIdTest {

    public static RoleId create(String value) {
        return new RoleId(value);
    }

    public static RoleId random() {
        return create(UuidMother.random());
    }
}
