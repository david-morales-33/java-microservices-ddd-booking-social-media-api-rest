package com.dmx.profile.user_profile.domain;

import com.dmx.profile.shared.domain.EmailMother;

public final class UserProfileEmailMother {
    public static UserProfileEmail create(String value){
        return new UserProfileEmail(value);
    }
    public static UserProfileEmail random(){
        return new UserProfileEmail(EmailMother.random());
    }
}
