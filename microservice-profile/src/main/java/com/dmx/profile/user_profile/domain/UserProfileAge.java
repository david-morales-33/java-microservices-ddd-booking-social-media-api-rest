package com.dmx.profile.user_profile.domain;

import com.dmx.profile.shared.domain.IntValueObject;

public final class UserProfileAge extends IntValueObject {
    public UserProfileAge( Integer value){
        super(value);
    }
    private UserProfileAge(){
        super(null);
    }
}
