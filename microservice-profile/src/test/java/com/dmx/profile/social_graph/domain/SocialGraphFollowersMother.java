package com.dmx.profile.social_graph.domain;

import com.dmx.profile.shared.domain.IntegerMother;

public final class SocialGraphFollowersMother {
    public static SocialGraphFollowers create(Double value) {
        return new SocialGraphFollowers(value);
    }

    public static SocialGraphFollowers random() {
        return new SocialGraphFollowers(IntegerMother.random().doubleValue());
    }
}
