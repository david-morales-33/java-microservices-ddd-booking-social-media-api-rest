package com.dmx.profile.role.domain;

public final class RoleTest {
    public static Role create(RoleId id, RoleName name) {
        return new Role(id, name);
    }

    public static Role random() {
        return create(RoleIdTest.random(), RoleNameTest.random());
    }
}
