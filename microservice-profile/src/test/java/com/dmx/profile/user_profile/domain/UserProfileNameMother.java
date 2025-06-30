package com.dmx.profile.user_profile.domain;

import com.dmx.profile.shared.domain.WordMother;

public final class UserProfileNameMother {
    public static UserProfileName create(String value) {
        return new UserProfileName(value);
    }
    public static UserProfileName random(){
        return new UserProfileName(WordMother.random());
    }
}
