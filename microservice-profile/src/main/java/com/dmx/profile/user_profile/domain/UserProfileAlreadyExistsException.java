package com.dmx.profile.user_profile.domain;

import com.dmx.profile.shared.domain.DomainError;

public class UserProfileAlreadyExistsException extends DomainError {
    public UserProfileAlreadyExistsException(UserProfileId id) {
        super("USER_PROFILE_ALREADY_EXIST", String.format("The user profile <%s> already exist", id.value()));
    }
}
