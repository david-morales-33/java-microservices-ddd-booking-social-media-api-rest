package com.dmx.profile.social_graph.domain;

import com.dmx.profile.shared.domain.IntegerMother;

public final class SocialGraphMatchesMother {
    public static SocialGraphMatches create(Double value) {
        return new SocialGraphMatches(value);
    }

    public static SocialGraphMatches random() {
        return new SocialGraphMatches(IntegerMother.random().doubleValue());
    }

}
