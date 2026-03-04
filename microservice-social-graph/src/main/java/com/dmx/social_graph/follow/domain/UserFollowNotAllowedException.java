package com.dmx.social_graph.follow.domain;

import com.dmx.social_graph.shared.domain.DomainException;

public class UserFollowNotAllowedException extends DomainException {
    public UserFollowNotAllowedException(UserId userId, UserId followerId) {
        super("FOLLOW_NOT_ALLOWED",String.format("User %s cannot follow user %s", followerId.value(), userId.value()));
    }
}
