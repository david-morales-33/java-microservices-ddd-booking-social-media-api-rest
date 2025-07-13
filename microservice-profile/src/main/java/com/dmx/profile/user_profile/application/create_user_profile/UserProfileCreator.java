package com.dmx.profile.user_profile.application.create_user_profile;

import com.dmx.profile.photo.domain.Photo;
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
            UserProfileDescription description,
            Photo photo,
            Status status
    ) throws UserProfileAlreadyExistsException {
        UserProfile profile = UserProfile.create(id, name, nickname, email, age, gender, description, photo, status);
        Optional<UserProfile> response = this.repository.find(id);

        if (response.isPresent()) throw new UserProfileAlreadyExistsException(id);

        this.repository.save(profile);
    }
}
