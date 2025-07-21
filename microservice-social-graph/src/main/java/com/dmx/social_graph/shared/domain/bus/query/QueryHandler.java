package com.dmx.social_graph.shared.domain.bus.query;

import com.dmx.profile.shared.domain.bus.query.Response;

public interface QueryHandler<Q extends Query, R extends Response> {
    R handle(Q query);
}
