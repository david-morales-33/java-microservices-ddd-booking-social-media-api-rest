package com.dmx.social_graph.follow.application.follow_user;

import com.dmx.social_graph.follow.domain.UserId;
import com.dmx.social_graph.shared.domain.bus.command.CommandHandler;

public class FollowUserCommandHandler implements CommandHandler<FollowUserCommand> {
    private final UserFollower follower;

    public FollowUserCommandHandler(UserFollower follower) {
        this.follower = follower;
    }

    @Override
    public void handle(FollowUserCommand command) {
        UserId userId = new UserId(command.getUserId());
        UserId followerId = new UserId(command.getFollowerId());

        this.follower.execute(userId, followerId);
    }
}
