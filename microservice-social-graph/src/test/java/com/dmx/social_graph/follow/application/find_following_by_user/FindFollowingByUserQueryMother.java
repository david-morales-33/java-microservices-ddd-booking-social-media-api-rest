package com.dmx.social_graph.follow.application.find_following_by_user;

import com.dmx.social_graph.follow.domain.UserIdTest;

public class FindFollowingByUserQueryMother {
    public static FindFollowingByUserQuery create(String userId) {
        return new FindFollowingByUserQuery(userId);
    }

    public static FindFollowingByUserQuery random() {
        return new FindFollowingByUserQuery(UserIdTest.random().value());
    }
}
