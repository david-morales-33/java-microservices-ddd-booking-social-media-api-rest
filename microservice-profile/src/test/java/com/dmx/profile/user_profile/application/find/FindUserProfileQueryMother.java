package com.dmx.profile.user_profile.application.find;

import com.dmx.profile.shared.domain.UuidMother;

public final class FindUserProfileQueryMother {
    public static FindUserProfileQuery create(String id) {
        return new FindUserProfileQuery(id);
    }

    public static FindUserProfileQuery random() {
        return new FindUserProfileQuery(UuidMother.random());
    }
}
