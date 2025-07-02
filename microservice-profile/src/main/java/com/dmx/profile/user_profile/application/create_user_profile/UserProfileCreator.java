package com.dmx.profile.user_profile.application.create_user_profile;

import com.dmx.profile.description.domain.Description;
import com.dmx.profile.shared.domain.Service;
import com.dmx.profile.status.domain.Status;
import com.dmx.profile.user_profile.domain.*;

import java.util.Optional;

@Service
public final class UserProfileCreator {
    private final UserProfileRepository repository;

    public UserProfileCreator(UserProfileRepository repository) {
        this.repository = repository;
    }

    void execute(
            UserProfileId id,
            UserProfileName name,
            UserProfileNickname nickname,
            UserProfileEmail email,
            UserProfileAge age,
            UserProfileGender gender,
            Status status,
            Description description
    ) throws UserProfileAlreadyExistsException {
        UserProfile profile = UserProfile.create(id, name, nickname, email, age, gender, status, description);
        Optional<UserProfile> response = this.repository.find(id);

        if (response.isPresent()) throw new UserProfileAlreadyExistsException("User already exists");

        this.repository.save(profile);
    }
}
