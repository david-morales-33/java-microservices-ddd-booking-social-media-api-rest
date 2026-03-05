package com.dmx.social_graph.follow.application.find_followers_by_user;

import com.dmx.social_graph.follow.domain.UserIdTest;

public class FindFollowerByUserQueryMother {
    public static FindFollowerByUserQuery create(String userId) {
        return new FindFollowerByUserQuery(userId);
    }

    public static FindFollowerByUserQuery random() {
        return new FindFollowerByUserQuery(UserIdTest.random().value());
    }
}

