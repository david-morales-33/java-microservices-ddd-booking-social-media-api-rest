package com.dmx.social_graph.follow.domain;

public enum FollowStatus {
    ACTIVE("active"),
    UNFOLLOWED("unfollowed"),
    BLOCKED("blocked");

    private final String status;

    FollowStatus(String status) {
        this.status = status;
    }

    public String value() {
        return status;
    }
}
