package com.dmx.profile.shared.infrastructure.bus.query;

import com.dmx.profile.shared.domain.bus.query.Query;

public class QueryNotRegisteredError extends Exception {
    public QueryNotRegisteredError(Class<? extends Query> query) {
        super(String.format("The query <%s> hasn't a query handler associated", query.toString()));
    }
}
