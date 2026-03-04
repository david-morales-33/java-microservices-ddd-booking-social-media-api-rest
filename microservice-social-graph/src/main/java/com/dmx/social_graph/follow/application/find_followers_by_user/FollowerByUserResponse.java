package com.dmx.social_graph.follow.application.find_followers_by_user;

import com.dmx.social_graph.follow.domain.Follow;
import com.dmx.social_graph.follow.domain.FollowDTO;
import com.dmx.social_graph.shared.domain.bus.query.Response;

import java.util.List;

public final class FollowerByUserResponse implements Response {
    private final List<FollowDTO> followers;

    public FollowerByUserResponse(List<Follow> followers) {
        this.followers = followers.stream().map(Follow::toPrimitives).toList();
    }

    public List<FollowDTO> followers() {
        return followers;
    }
}
