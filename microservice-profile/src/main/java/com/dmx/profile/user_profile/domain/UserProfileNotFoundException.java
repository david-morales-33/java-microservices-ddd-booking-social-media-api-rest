package com.dmx.profile.user_profile.domain;

import com.dmx.profile.shared.domain.DomainError;

public class UserProfileNotFoundException extends DomainError {
    public UserProfileNotFoundException(UserProfileId id) {
        super("USER_PROFILE_NOT_EXISTS", String.format("The user profile <%s> doesn't exist", id.value()));
    }
}
