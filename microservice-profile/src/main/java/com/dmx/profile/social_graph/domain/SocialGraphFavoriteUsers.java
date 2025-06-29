package com.dmx.profile.social_graph.domain;

import com.dmx.profile.shared.domain.DoubleValueObject;

public final class SocialGraphFavoriteUsers extends DoubleValueObject {
    public SocialGraphFavoriteUsers(Double value) {
        super(value);
    }

    private SocialGraphFavoriteUsers() {
        super(null);
    }
}
