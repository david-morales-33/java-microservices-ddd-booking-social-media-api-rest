package com.dmx.profile.social_graph.domain;

import com.dmx.profile.shared.domain.DoubleValueObject;

public final class SocialGraphFollows extends DoubleValueObject {
    public SocialGraphFollows(Double value) {
        super(value);
    }

    private SocialGraphFollows() {
        super(null);
    }
}
