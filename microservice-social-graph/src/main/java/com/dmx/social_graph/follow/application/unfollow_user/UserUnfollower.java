package com.dmx.social_graph.follow.application.unfollow_user;

import com.dmx.social_graph.follow.domain.Follow;
import com.dmx.social_graph.follow.domain.FollowDoesNotExistException;
import com.dmx.social_graph.follow.domain.FollowRepository;
import com.dmx.social_graph.follow.domain.UserId;

import java.util.Optional;

public class UserUnfollower {
    private final FollowRepository repository;

    public UserUnfollower(FollowRepository repository) {
        this.repository = repository;
    }

    public void execute(UserId userId, UserId followerId) {
        Optional<Follow> response = repository.findByUsers(userId, followerId);

        if (response.isEmpty()) throw new FollowDoesNotExistException();

        Follow follow = response.get();

        follow.unfollow();

        repository.save(follow);
    }
}
