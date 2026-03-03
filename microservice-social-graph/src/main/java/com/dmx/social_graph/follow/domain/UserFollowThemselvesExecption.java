package com.dmx.social_graph.follow.domain;

import com.dmx.social_graph.shared.domain.DomainException;

public class UserFollowThemselvesExecption extends DomainException {
    public UserFollowThemselvesExecption(UserId id) {
        super("USER_FOLLOW_THEMSELVES", String.format("User <%s> cannot follow themselves", id.value()));
    }
}
