package com.dmx.social_graph.follow.domain;

import com.dmx.social_graph.shared.domain.BooleanMother;

public final class FollowFavoriteTest {
    public static FollowFavorite create(boolean value) {
        return FollowFavorite.of(value);
    }

    public static FollowFavorite random() {
        return FollowFavorite.of(BooleanMother.random());
    }

    public static FollowFavorite marked() {
        return FollowFavorite.of(true);
    }

    public static FollowFavorite unmarked() {
        return FollowFavorite.of(false);
    }
}

