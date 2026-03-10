package com.dmx.social_graph.follow.application.find_followers_by_user;

import com.dmx.social_graph.shared.domain.bus.query.Query;

public class FindFollowerByUserQuery implements Query {
    private final String userId;

    public FindFollowerByUserQuery(String userId) {
        this.userId = userId;
    }

    public String userId() {
        return userId;
    }
}

