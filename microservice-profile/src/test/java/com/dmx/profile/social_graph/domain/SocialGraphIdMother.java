package com.dmx.profile.social_graph.domain;

import com.dmx.profile.shared.domain.UuidMother;

public final class SocialGraphIdMother {
    public static SocialGraphId create(String value) {
        return new SocialGraphId(value);
    }

    public static SocialGraphId random() {
        return new SocialGraphId(UuidMother.random());
    }
}
