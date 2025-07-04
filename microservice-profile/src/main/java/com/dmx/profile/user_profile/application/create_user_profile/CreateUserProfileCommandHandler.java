package com.dmx.profile.user_profile.application.create_user_profile;

import com.dmx.profile.description.domain.Description;
import com.dmx.profile.shared.domain.Service;
import com.dmx.profile.shared.domain.bus.command.CommandHandler;
import com.dmx.profile.status.domain.Status;
import com.dmx.profile.user_profile.domain.*;

@Service
public final class CreateUserProfileCommandHandler implements CommandHandler<CreateUserProfileCommand> {

    private final UserProfileCreator creator;

    public CreateUserProfileCommandHandler(UserProfileCreator creator) {
        this.creator = creator;
    }

    @Override
    public void handle(CreateUserProfileCommand command) {

        UserProfileId id = new UserProfileId(command.getId());
        UserProfileName name = new UserProfileName(command.getName());
        UserProfileNickname nickname = new UserProfileNickname(command.getNickname());
        UserProfileAge age = new UserProfileAge(command.getAge());
        UserProfileEmail email = new UserProfileEmail(command.getEmail());
        UserProfileGender gender = new UserProfileGender(command.getGender());
        Description description = Description.fromPrimitives(command.getDescription());
        Status status = Status.fromPrimitives(command.getStatus());

        this.creator.execute(id, name, nickname, email, age, gender, status, description);
    }
}
