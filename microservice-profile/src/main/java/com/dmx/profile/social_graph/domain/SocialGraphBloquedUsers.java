package com.dmx.profile.social_graph.domain;

import com.dmx.profile.shared.domain.DoubleValueObject;

public final class SocialGraphBloquedUsers extends DoubleValueObject {
    public SocialGraphBloquedUsers(Double value) {
        super(value);
    }

    private SocialGraphBloquedUsers() {
        super(null);
    }
}
