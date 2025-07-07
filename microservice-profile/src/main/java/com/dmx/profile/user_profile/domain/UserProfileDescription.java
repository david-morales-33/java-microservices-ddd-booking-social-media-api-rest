package com.dmx.profile.user_profile.domain;

import com.dmx.profile.shared.domain.StringValueObject;

public final class UserProfileDescription extends StringValueObject {
    public UserProfileDescription(String value) {
        super(value);
    }

    private UserProfileDescription() {
        super(null);
    }
}
