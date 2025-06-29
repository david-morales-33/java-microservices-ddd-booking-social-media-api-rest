package com.dmx.profile.social_graph.domain;

import com.dmx.profile.shared.domain.FloatMother;

public final class SocialGraphRatingMother {
    public static SocialGraphRating create(Float value) {
        return new SocialGraphRating(value);
    }
    public static SocialGraphRating random() {
        return new SocialGraphRating(FloatMother.random());
    }
}
