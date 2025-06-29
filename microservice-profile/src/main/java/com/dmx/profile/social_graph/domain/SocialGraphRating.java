package com.dmx.profile.social_graph.domain;

import com.dmx.profile.shared.domain.FloatValueObject;

public final class SocialGraphRating extends FloatValueObject {
    public SocialGraphRating(Float value) {
        super(value);
    }

    private SocialGraphRating() {
        super(null);
    }
}
