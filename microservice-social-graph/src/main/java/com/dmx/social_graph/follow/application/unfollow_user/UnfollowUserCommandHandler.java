package com.dmx.social_graph.follow.application.unfollow_user;

import com.dmx.social_graph.follow.domain.UserId;
import com.dmx.social_graph.shared.domain.bus.command.CommandHandler;

public class UnfollowUserCommandHandler implements CommandHandler<UnfollowUserCommand> {
    private final UserUnfollower userUnfollower;

    public UnfollowUserCommandHandler(UserUnfollower userUnfollower) {
        this.userUnfollower = userUnfollower;
    }

    @Override
    public void handle(UnfollowUserCommand command) {
        UserId userId = new UserId(command.getUserId());
        UserId followerId = new UserId(command.getFollowerId());
        userUnfollower.execute(userId, followerId);
    }
}
