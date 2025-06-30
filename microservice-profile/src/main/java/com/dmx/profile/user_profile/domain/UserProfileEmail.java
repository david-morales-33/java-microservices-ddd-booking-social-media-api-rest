package com.dmx.profile.user_profile.domain;

import com.dmx.profile.shared.domain.StringValueObject;

public final class UserProfileEmail extends StringValueObject {
    public UserProfileEmail(String value) {
        super(value);
    }

    private UserProfileEmail() {
        super(null);
    }
}
