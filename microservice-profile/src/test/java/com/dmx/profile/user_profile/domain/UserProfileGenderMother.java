package com.dmx.profile.user_profile.domain;

import com.dmx.profile.shared.domain.WordMother;

public final class UserProfileGenderMother {
    public static UserProfileGender create(String value) {
        return new UserProfileGender(value);
    }

    public static UserProfileGender random() {
        return new UserProfileGender(WordMother.random());
    }
}
