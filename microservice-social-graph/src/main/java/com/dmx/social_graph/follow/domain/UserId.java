package com.dmx.social_graph.follow.domain;

import com.dmx.social_graph.shared.domain.Identifier;

public class UserId extends Identifier {
    public UserId(String value) {
        super(value);
    }

    private UserId() {
    }
}
