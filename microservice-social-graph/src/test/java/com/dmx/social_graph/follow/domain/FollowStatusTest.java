package com.dmx.social_graph.follow.domain;

import com.dmx.social_graph.shared.domain.EnumMother;

public final class FollowStatusTest {
    public static FollowStatus random() {
        return EnumMother.random(FollowStatus.class);
    }

    public static FollowStatus create(FollowStatus status) {
        return status;
    }

    public static FollowStatus active() {
        return FollowStatus.ACTIVE;
    }

    public static FollowStatus unfollowed() {
        return FollowStatus.UNFOLLOWED;
    }

    public static FollowStatus blocked() {
        return FollowStatus.BLOCKED;
    }
}

