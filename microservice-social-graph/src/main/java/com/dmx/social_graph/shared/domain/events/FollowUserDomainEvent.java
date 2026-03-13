package com.dmx.social_graph.shared.domain.events;

import com.dmx.social_graph.shared.domain.bus.event.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

public class FollowUserDomainEvent extends DomainEvent {

    private final String followerId;
    private final String followedId;

    public FollowUserDomainEvent(String aggregateId) {
        super(null);
        this.followedId = null;
        this.followerId = null;
    }

    public FollowUserDomainEvent(String aggregateId, String followerId, String followedId) {
        super(aggregateId);
        this.followerId = followerId;
        this.followedId = followedId;
    }

    public FollowUserDomainEvent(String aggregateId, String eventId, String occurredOn, String followerId, String followedId) {
        super(aggregateId, eventId, occurredOn);
        this.followerId = followerId;
        this.followedId = followedId;
    }

    @Override
    public String eventName() {
        return "follow.user";
    }

    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return new HashMap<String, Serializable>() {{
            put("followerId", followerId);
            put("followedId", followedId);
        }};
    }

    @Override
    public FollowUserDomainEvent fromPrimitives(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
        return new FollowUserDomainEvent(
                aggregateId,
                eventId,
                occurredOn,
                (String) body.get("followerId"),
                (String) body.get("followedId")
        );
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        FollowUserDomainEvent that = (FollowUserDomainEvent) o;
        return followerId.equals(that.followerId) && followedId.equals(that.followedId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(followerId, followedId);
    }
}
