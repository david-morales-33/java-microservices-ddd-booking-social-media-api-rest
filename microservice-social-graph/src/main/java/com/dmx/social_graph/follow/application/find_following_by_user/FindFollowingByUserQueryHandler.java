package com.dmx.social_graph.follow.application.find_following_by_user;

import com.dmx.social_graph.follow.domain.UserId;
import com.dmx.social_graph.shared.domain.Service;
import com.dmx.social_graph.shared.domain.bus.query.QueryHandler;

@Service
public final class FindFollowingByUserQueryHandler implements QueryHandler<FindFollowingByUserQuery, FollowingByUserResponse> {

    private final FollowingByUserFinder finder;

    public FindFollowingByUserQueryHandler(FollowingByUserFinder finder) {
        this.finder = finder;
    }

    @Override
    public FollowingByUserResponse handle(FindFollowingByUserQuery query) {
        UserId userId = new UserId(query.userId());
        return this.finder.execute(userId);
    }
}
