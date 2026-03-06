package com.dmx.social_graph.block.domain;

import com.dmx.social_graph.shared.domain.UuidMother;

public final class UserIdTest {
    public static UserId create(String value) {
        return new UserId(value);
    }

    public static UserId random() {
        return new UserId(UuidMother.random());
    }
}
