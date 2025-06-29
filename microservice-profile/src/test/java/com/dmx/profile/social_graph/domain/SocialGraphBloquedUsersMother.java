package com.dmx.profile.social_graph.domain;

import com.dmx.profile.shared.domain.IntegerMother;

public final class SocialGraphBloquedUsersMother {
    public static SocialGraphBloquedUsers create(Double value) {
        return new SocialGraphBloquedUsers(value);
    }

    public static SocialGraphBloquedUsers random() {
        return new SocialGraphBloquedUsers(IntegerMother.random().doubleValue());
    }
}
