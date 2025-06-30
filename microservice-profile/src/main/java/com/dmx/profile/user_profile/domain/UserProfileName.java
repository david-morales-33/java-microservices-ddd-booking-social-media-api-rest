package com.dmx.profile.user_profile.domain;

import com.dmx.profile.shared.domain.StringValueObject;

public final class UserProfileName extends StringValueObject {
    public UserProfileName(String value) {
        super(value);
    }

    private UserProfileName() {
        super(null);
    }
}
