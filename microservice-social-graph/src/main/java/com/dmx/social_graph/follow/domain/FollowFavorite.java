package com.dmx.social_graph.follow.domain;

import com.dmx.social_graph.shared.domain.BooleanValueObject;

public class FollowFavorite extends BooleanValueObject {
    public FollowFavorite(boolean value) {
        super(value);
    }
    public static FollowFavorite of(boolean value) {
        return new FollowFavorite(value);
    }
}
