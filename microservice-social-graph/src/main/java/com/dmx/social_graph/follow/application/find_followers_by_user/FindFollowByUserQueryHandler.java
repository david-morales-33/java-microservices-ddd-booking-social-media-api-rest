package com.dmx.social_graph.follow.application.find_followers_by_user;

import com.dmx.social_graph.follow.domain.UserId;
import com.dmx.social_graph.shared.domain.Service;
import com.dmx.social_graph.shared.domain.bus.query.QueryHandler;

@Service
public final class FindFollowByUserQueryHandler implements QueryHandler<FindFollowerByUserQuery, FollowerByUserResponse> {

    private final FollowByUserFinder finder;

    public FindFollowByUserQueryHandler(FollowByUserFinder finder) {
        this.finder = finder;
    }

    @Override
    public FollowerByUserResponse handle(FindFollowerByUserQuery query) {
        UserId userId = new UserId(query.userId());
        return this.finder.execute(userId);
    }
}
