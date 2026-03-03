package com.dmx.social_graph.user.domain;

import com.dmx.social_graph.shared.domain.StringValueObject;

public final class UserName extends StringValueObject {
    public UserName(String value) {
        super(value);
    }

    public UserName() {
        super(null);
    }

}
