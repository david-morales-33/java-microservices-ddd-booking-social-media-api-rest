package com.dmx.social_graph.follow.application.follow_user;

import com.dmx.social_graph.follow.domain.Follow;
import com.dmx.social_graph.follow.domain.FollowRepository;
import com.dmx.social_graph.follow.domain.UserFollowNotAllowedException;
import com.dmx.social_graph.follow.domain.UserId;

public class UserFollower {
        private final FollowRepository repository;

        public UserFollower(FollowRepository repository) {
            this.repository = repository;
        }

        public void execute(UserId userId, UserId followerId) {
            Follow follow = Follow.create(userId, followerId);
            if (this.repository.existsActiveFollow(followerId, userId)) {
                throw new UserFollowNotAllowedException(userId, followerId);
            }
            this.repository.save(follow);
        }
}
