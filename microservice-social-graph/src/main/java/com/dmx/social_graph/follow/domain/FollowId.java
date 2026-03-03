package com.dmx.social_graph.follow.domain;

import com.dmx.social_graph.shared.domain.Identifier;

public class FollowId extends Identifier {

    public FollowId(String value) {
        super(value);
    }

    public static FollowId of(String value) {
        return new FollowId(value);
    }
}
