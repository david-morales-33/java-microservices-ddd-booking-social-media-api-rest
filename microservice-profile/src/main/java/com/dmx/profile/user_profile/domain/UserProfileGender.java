package com.dmx.profile.user_profile.domain;

import com.dmx.profile.shared.domain.StringValueObject;

public final class UserProfileGender extends StringValueObject {
    public UserProfileGender(String value) {
        super(value);
    }

    private UserProfileGender() {
        super(null);
    }
}
