package com.dmx.profile.role.domain;

import com.dmx.profile.shared.domain.WordTest;

public final class RoleNameTest {
    public static RoleName create(String value) {
        return new RoleName(value);
    }

    public static RoleName random() {
        return create(WordTest.random());
    }
}
