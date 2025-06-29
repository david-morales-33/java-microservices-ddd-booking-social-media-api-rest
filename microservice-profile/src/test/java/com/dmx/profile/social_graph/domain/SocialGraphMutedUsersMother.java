package com.dmx.profile.social_graph.domain;

import com.dmx.profile.shared.domain.IntegerMother;

public final class SocialGraphMutedUsersMother {
    public static SocialGraphMutedUsers create(Double value) {
        return new SocialGraphMutedUsers(value);
    }

    public static SocialGraphMutedUsers random() {
        return new SocialGraphMutedUsers(IntegerMother.random().doubleValue());
    }
}
