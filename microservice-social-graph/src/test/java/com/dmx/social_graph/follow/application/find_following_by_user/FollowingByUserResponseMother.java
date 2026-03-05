package com.dmx.social_graph.follow.application.find_following_by_user;

import com.dmx.social_graph.follow.domain.Follow;
import com.dmx.social_graph.follow.domain.FollowTest;

import java.util.List;

public class FollowingByUserResponseMother {
    public static FollowingByUserResponse create(Follow follow) {
        return new FollowingByUserResponse(List.of(follow));
    }

    public static FollowingByUserResponse random() {
        return new FollowingByUserResponse(List.of(FollowTest.random()));
    }

    public static FollowingByUserResponse empty() {
        return new FollowingByUserResponse(List.of());
    }
}
