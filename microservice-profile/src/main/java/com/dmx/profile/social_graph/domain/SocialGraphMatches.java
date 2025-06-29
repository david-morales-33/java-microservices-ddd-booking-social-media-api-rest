package com.dmx.profile.social_graph.domain;

import com.dmx.profile.shared.domain.DoubleValueObject;

public final class SocialGraphMatches extends DoubleValueObject {
    public SocialGraphMatches(Double value) {
        super(value);
    }

    private SocialGraphMatches() {
        super(null);
    }
}
