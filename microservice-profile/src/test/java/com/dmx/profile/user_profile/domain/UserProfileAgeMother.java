package com.dmx.profile.user_profile.domain;

import com.dmx.profile.shared.domain.IntegerMother;

public final class UserProfileAgeMother {
    public static UserProfileAge create(Integer value) {
        return new UserProfileAge(value);
    }

    public static UserProfileAge random() {
        return new UserProfileAge(IntegerMother.random() * IntegerMother.random());
    }
}
