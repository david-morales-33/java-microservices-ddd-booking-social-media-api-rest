package com.dmx.profile.social_graph.domain;

import com.dmx.profile.shared.domain.IntegerMother;

public final class SocialGraphFollowsMother {
    public static SocialGraphFollows create(Double value){
        return new SocialGraphFollows(value);
    }
    public static SocialGraphFollows random(){
        return new SocialGraphFollows(IntegerMother.random().doubleValue());
    }
}
