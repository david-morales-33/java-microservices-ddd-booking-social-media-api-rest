package com.dmx.profile.user_profile.domain;

import com.dmx.profile.shared.domain.Identifier;

public final class UserProfileId extends Identifier {
    public UserProfileId(String value) {
        super(value);
    }

    private UserProfileId() {
    }
}
