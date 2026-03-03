package com.dmx.social_graph.follow.domain;

import com.dmx.social_graph.shared.domain.DomainException;

public class UnfollowException extends DomainException {
    public UnfollowException (){
        super("UNFOLLOW_ERROR", "Unable to unfollow the user");
    }
}
