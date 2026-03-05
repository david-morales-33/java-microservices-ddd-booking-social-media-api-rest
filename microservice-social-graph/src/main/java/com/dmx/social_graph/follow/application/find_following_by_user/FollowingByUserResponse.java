package com.dmx.social_graph.follow.application.find_following_by_user;

import com.dmx.social_graph.follow.domain.Follow;
import com.dmx.social_graph.follow.domain.FollowDTO;
import com.dmx.social_graph.shared.domain.bus.query.Response;

import java.util.List;

public final class FollowingByUserResponse implements Response {
    private final List<FollowDTO> following;

    public FollowingByUserResponse(List<Follow> following) {
        this.following = following.stream().map(Follow::toPrimitives).toList();
    }

    public List<FollowDTO> following() {
        return following;
    }
}
