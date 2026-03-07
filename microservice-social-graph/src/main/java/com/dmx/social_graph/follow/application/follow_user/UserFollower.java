package com.dmx.social_graph.follow.application.follow_user;

import com.dmx.social_graph.follow.domain.Follow;
import com.dmx.social_graph.follow.domain.FollowRepository;
import com.dmx.social_graph.follow.domain.UserFollowNotAllowedException;
import com.dmx.social_graph.follow.domain.UserId;
import com.dmx.social_graph.shared.domain.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserFollower {
    private final FollowRepository repository;

    public UserFollower(FollowRepository repository) {
        this.repository = repository;
    }

    @Transactional("social_graph-transaction_manager")
    public void execute(UserId userId, UserId followerId) {
        Follow follow = Follow.create(userId, followerId);
        if (this.repository.existsActiveFollow(followerId, userId)) {
            throw new UserFollowNotAllowedException(userId, followerId);
        }
        this.repository.save(follow);
    }
}
