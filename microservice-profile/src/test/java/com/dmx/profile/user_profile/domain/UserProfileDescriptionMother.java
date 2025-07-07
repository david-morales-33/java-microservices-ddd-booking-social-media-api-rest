package com.dmx.profile.user_profile.domain;

import com.dmx.profile.shared.domain.WordMother;

public final class UserProfileDescriptionMother {
    public static UserProfileDescription create(String value) {
        return new UserProfileDescription(value);
    }

    public static UserProfileDescription random() {
        return new UserProfileDescription(WordMother.random());
    }
}
