package com.dmx.profile.user_profile.application.create;

import com.dmx.profile.description.domain.Description;
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
            Status status,
            Description description
    ) {
        return new CreateUserProfileCommand(id.value(), name.value(), nickname.value(), email.value(), age.value(), gender.value(), status.toPrimitives(), description.toPrimitives());
    }
}
