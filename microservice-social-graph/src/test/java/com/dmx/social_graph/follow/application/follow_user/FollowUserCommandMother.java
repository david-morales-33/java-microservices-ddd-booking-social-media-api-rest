package com.dmx.social_graph.follow.application.follow_user;

public class FollowUserCommandMother {
    public static FollowUserCommand create(String userId, String followerId) {
        return new FollowUserCommand(userId, followerId);
    }

}
