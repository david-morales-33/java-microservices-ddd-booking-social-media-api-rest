package com.dmx.social_graph.user.domain;

import com.dmx.social_graph.shared.domain.StringValueObject;

public final class UserPhoto extends StringValueObject {
    public UserPhoto(String value) {
        super(value);
    }

    public UserPhoto() {
        super(null);
    }
}
