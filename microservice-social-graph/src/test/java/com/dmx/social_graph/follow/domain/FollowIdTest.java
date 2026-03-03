package com.dmx.social_graph.follow.domain;

import com.dmx.social_graph.shared.domain.UuidMother;

public final class FollowIdTest {
    public static FollowId create(String value) {
        return new FollowId(value);
    }

    public static FollowId random() {
        return new FollowId(UuidMother.random());
    }
}


