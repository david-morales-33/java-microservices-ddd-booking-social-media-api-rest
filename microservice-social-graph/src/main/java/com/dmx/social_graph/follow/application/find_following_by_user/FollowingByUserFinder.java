package com.dmx.social_graph.follow.application.find_following_by_user;

import com.dmx.social_graph.follow.domain.Follow;
import com.dmx.social_graph.follow.domain.FollowRepository;
import com.dmx.social_graph.follow.domain.UserId;

import java.util.List;

public final class FollowingByUserFinder {
    private final FollowRepository repository;

    public FollowingByUserFinder(FollowRepository repository) {
        this.repository = repository;
    }

    public FollowingByUserResponse execute(UserId userId) {
        List<Follow> following = this.repository.findFollowingOf(userId);
        return new FollowingByUserResponse(following);
    }
}
