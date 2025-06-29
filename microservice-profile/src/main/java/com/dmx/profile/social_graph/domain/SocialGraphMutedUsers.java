package com.dmx.profile.social_graph.domain;

import com.dmx.profile.shared.domain.DoubleValueObject;

public final class SocialGraphMutedUsers extends DoubleValueObject {
    public SocialGraphMutedUsers(Double value) {
        super(value);
    }

    private SocialGraphMutedUsers() {
        super(null);
    }
}
