package com.dmx.profile.user_profile.application.find;

import com.dmx.profile.user_profile.domain.UserProfileDTO;
import com.dmx.profile.user_profile.domain.UserProfileMother;

public final class UserProfileResponseMother {
    public static UserProfileResponse create(UserProfileDTO profile) {
        return new UserProfileResponse(profile);
    }

    public static UserProfileResponse random() {
        return new UserProfileResponse(UserProfileMother.random().toPrimitives());
    }
}
