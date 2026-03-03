package com.dmx.social_graph.follow.domain;

import com.dmx.social_graph.shared.domain.BooleanValueObject;

public class FollowMuted extends BooleanValueObject {
    public FollowMuted(boolean value) {
        super(value);
    }

    public static FollowMuted of(boolean value) {
        return new FollowMuted(value);
    }
}
