package com.dmx.social_graph.user.domain;

import com.dmx.social_graph.shared.domain.StringValueObject;

public final class UserNickname extends StringValueObject {
    public UserNickname(String value) {
        super(value);
    }

    public UserNickname() {
        super(null);
    }
}
