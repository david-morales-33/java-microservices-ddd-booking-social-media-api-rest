package com.dmx.social_graph.follow.application.unfollow_user;

import com.dmx.social_graph.follow.domain.UserId;

public class UnfollowUserCommandMother {
    public static UnfollowUserCommand create(String userId, String followerId) {
        return new UnfollowUserCommand(userId, followerId);
    }
}
