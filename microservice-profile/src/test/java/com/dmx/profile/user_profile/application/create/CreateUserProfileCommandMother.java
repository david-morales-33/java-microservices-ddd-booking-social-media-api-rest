package com.dmx.profile.user_profile.application.create;

import com.dmx.profile.photo.domain.Photo;
import com.dmx.profile.status.domain.Status;
import com.dmx.profile.user_profile.application.create_user_profile.CreateUserProfileCommand;
import com.dmx.profile.user_profile.domain.*;

public final class CreateUserProfileCommandMother {
    public static CreateUserProfileCommand create(
            UserProfileId id,
            UserProfileName name,
            UserProfileNickname nickname,
            UserProfileEmail email,
            UserProfileAge age,
            UserProfileGender gender,
            UserProfileDescription description,
            Photo photo,
            Status status
    ) {
        return new CreateUserProfileCommand(id.value(), name.value(), nickname.value(), email.value(), age.value(), gender.value(), description.value(), photo.toPrimitives(), status.toPrimitives());
    }
}
