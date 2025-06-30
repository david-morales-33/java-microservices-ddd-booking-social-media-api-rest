package com.dmx.profile.user_profile.domain;

import com.dmx.profile.shared.domain.UuidMother;

public final class UserProfileIdMother {
    static public UserProfileId create(String id) {
        return new UserProfileId(id);
    }

    static public UserProfileId random() {
        return new UserProfileId(UuidMother.random());
    }
}
