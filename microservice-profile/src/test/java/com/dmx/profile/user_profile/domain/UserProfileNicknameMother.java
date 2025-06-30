package com.dmx.profile.user_profile.domain;

import com.dmx.profile.shared.domain.WordMother;

public final class UserProfileNicknameMother {
    public static UserProfileNickname create(String value) {
        return new UserProfileNickname(value);
    }

    public static UserProfileNickname random() {
        return new UserProfileNickname(WordMother.random());
    }
}
