package com.dmx.profile.user_profile.application.create;

import com.dmx.profile.description.domain.*;
import com.dmx.profile.status.domain.Status;
import com.dmx.profile.status.domain.StatusIdMother;
import com.dmx.profile.status.domain.StatusLabelMother;
import com.dmx.profile.status.domain.StatusMother;
import com.dmx.profile.user_profile.UserProfileUnitCaseTest;
import com.dmx.profile.user_profile.application.create_user_profile.CreateUserProfileCommand;
import com.dmx.profile.user_profile.application.create_user_profile.CreateUserProfileCommandHandler;
import com.dmx.profile.user_profile.application.create_user_profile.UserProfileCreator;
import com.dmx.profile.user_profile.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public final class CreateUserProfileUnitTest extends UserProfileUnitCaseTest {

    CreateUserProfileCommandHandler handler;

    @BeforeEach
    protected void setUp() {
        super.setUp();
        handler = new CreateUserProfileCommandHandler(new UserProfileCreator(repository));
    }

    @Test
    void it_should_create_a_new_user_profile() {
        //GIVEN
        CreateUserProfileCommand command = CreateUserProfileCommandMother.create(
                UserProfileIdMother.random(),
                UserProfileNameMother.random(),
                UserProfileNicknameMother.random(),
                UserProfileEmailMother.random(),
                UserProfileAgeMother.random(),
                UserProfileGenderMother.random(),
                StatusMother.random(),
                new Description(DescriptionIdMother.random(), DescriptionContentMother.random(), new HashMap<>())
        );
        UserProfile profile = UserProfileMother.create(
                UserProfileIdMother.create(command.getId()),
                UserProfileNameMother.create(command.getName()),
                UserProfileNicknameMother.create(command.getNickname()),
                UserProfileEmailMother.create(command.getEmail()),
                UserProfileAgeMother.create(command.getAge()),
                UserProfileGenderMother.create(command.getGender()),
                StatusMother.create(StatusIdMother.create(command.getStatus().id()), StatusLabelMother.create(command.getStatus().label())),
                DescriptionMother.create(
                        DescriptionIdMother.create(command.getDescription().id()),
                        DescriptionContentMother.create(command.getDescription().content()),
                        new HashMap<>()
                )
        );

        //WHEN
        shouldNotAnswerAnything(profile.getId());
        handler.handle(command);

        //THEN
        shouldVerifySavedUserProfile(profile);
    }

    @Test
    void it_should_throw_an_exception_when_user_profile_already_exists() {
        //GIVEN

        UserProfile profile = UserProfileMother.random();
        CreateUserProfileCommand command = CreateUserProfileCommandMother.create(
                profile.getId(),
                profile.getName(),
                profile.getNickname(),
                profile.getEmail(),
                profile.getAge(),
                profile.getGender(),
                profile.getStatus(),
                profile.getDescription()
        );
        //WHEN
        shouldAnswerAnyUserProfile(profile);

        //THEN
        assertThrows(UserProfileAlreadyExistsException.class, () -> handler.handle(command));
    }
}
