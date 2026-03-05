package com.dmx.social_graph.follow.application.find_followers_by_user;

import com.dmx.social_graph.follow.domain.Follow;
import com.dmx.social_graph.follow.domain.FollowTest;

import java.util.List;

public class FollowerByUserResponseMother {
    public static FollowerByUserResponse create(Follow follower) {
        return new FollowerByUserResponse(List.of(follower));
    }

    public static FollowerByUserResponse random() {
        return new FollowerByUserResponse(List.of(FollowTest.random()));
    }

    public static FollowerByUserResponse empty() {
        return new FollowerByUserResponse(List.of());
    }
}

