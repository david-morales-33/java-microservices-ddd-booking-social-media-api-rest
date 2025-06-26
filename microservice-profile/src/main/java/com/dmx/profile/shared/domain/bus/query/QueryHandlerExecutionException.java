package com.dmx.profile.shared.domain.bus.query;

public final class QueryHandlerExecutionException extends RuntimeException {
    public QueryHandlerExecutionException(Throwable message) {
        super(message);
    }
}
