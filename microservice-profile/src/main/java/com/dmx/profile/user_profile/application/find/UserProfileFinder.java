package com.dmx.profile.user_profile.application.find;

import com.dmx.profile.user_profile.domain.UserProfile;
import com.dmx.profile.user_profile.domain.UserProfileId;
import com.dmx.profile.user_profile.domain.UserProfileNotFoundException;
import com.dmx.profile.user_profile.domain.UserProfileRepository;

import java.util.Optional;

public final class UserProfileFinder {
    private final UserProfileRepository repository;

    public UserProfileFinder(UserProfileRepository repository) {
        this.repository = repository;
    }

    public UserProfileResponse execute(UserProfileId id) {
        Optional<UserProfile> response = this.repository.find(id);
        if (response.isEmpty()) throw new UserProfileNotFoundException("User not found");
        return new UserProfileResponse(response.get().toPrimitives());
    }
}
