package com.dmx.profile.user_profile.domain;

import com.dmx.profile.shared.domain.bus.event.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

public final class UserProfileCreatedDomainEvent extends DomainEvent {
    private final String name;
    private final String nickname;
    private final String email;

    public UserProfileCreatedDomainEvent() {
        super(null);
        this.name = null;
        this.nickname = null;
        this.email = null;
    }

    public UserProfileCreatedDomainEvent(String aggregateId, String name, String nickname, String email) {
        super(aggregateId);
        this.name = name;
        this.nickname = nickname;
        this.email = email;
    }


    public UserProfileCreatedDomainEvent(String aggregateId, String eventId, String occurredOn, String name, String nickname, String email) {
        super(aggregateId, eventId, occurredOn);
        this.name = name;
        this.nickname = nickname;
        this.email = email;
    }

    @Override
    public String eventName() {
        return "user_profile.created";
    }

    public String name() {
        return name;
    }

    public String nickname() {
        return nickname;
    }

    public String email() {
        return email;
    }

    @Override
    public HashMap<String, Serializable> toPrimitives() {
        HashMap<String, Serializable> map = new HashMap<>();
        map.put("name", name);
        map.put("nickname", nickname);
        map.put("email", email);
        return map;
    }

    @Override
    public UserProfileCreatedDomainEvent fromPrimitives(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
        return new UserProfileCreatedDomainEvent(
                aggregateId,
                eventId,
                occurredOn,
                (String) body.get("name"),
                (String) body.get("nickname"),
                (String) body.get("email")
        );
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserProfileCreatedDomainEvent that = (UserProfileCreatedDomainEvent) o;
        return name.equals(that.name) &&
                nickname.equals(that.nickname) &&
                email.equals(that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, nickname, email);
    }
}
