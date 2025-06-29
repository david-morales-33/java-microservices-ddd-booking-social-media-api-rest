package com.dmx.profile.social_graph.domain;

import com.dmx.profile.shared.domain.IntegerMother;

public final class SocialGraphFavoriteUsersMother {
    public static SocialGraphFavoriteUsers create(Double value) {
        return new SocialGraphFavoriteUsers(value);
    }

    public static SocialGraphFavoriteUsers random() {
        return new SocialGraphFavoriteUsers(IntegerMother.random().doubleValue());
    }
}
