package com.dmx.social_graph.follow.domain;

import com.dmx.social_graph.shared.domain.BooleanMother;

public final class FollowMutedTest {
    public static FollowMuted create(boolean value) {
        return FollowMuted.of(value);
    }

    public static FollowMuted random() {
        return FollowMuted.of(BooleanMother.random());
    }

    public static FollowMuted muted() {
        return FollowMuted.of(true);
    }

    public static FollowMuted unmuted() {
        return FollowMuted.of(false);
    }
}

