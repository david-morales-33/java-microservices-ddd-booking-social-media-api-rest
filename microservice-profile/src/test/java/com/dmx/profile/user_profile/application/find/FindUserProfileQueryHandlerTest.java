package com.dmx.profile.user_profile.application.find;

import com.dmx.profile.user_profile.UserProfileUnitCaseTest;
import com.dmx.profile.user_profile.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public final class FindUserProfileQueryHandlerTest extends UserProfileUnitCaseTest {
    FindUserProfileQueryHandler handler;

    @BeforeEach
    protected void setUp() {
        super.setUp();
        handler = new FindUserProfileQueryHandler(new UserProfileFinder(repository));
    }

    @Test
    void it_should_find_an_existenting_user_profile(){
        //GIVEN
        UserProfile profile = UserProfileMother.random();

        FindUserProfileQuery query = FindUserProfileQueryMother.create(profile.getId().value());
        UserProfileResponse response = UserProfileResponseMother.create(profile.toPrimitives());
        //WHEN
        shouldAnswerAnyUserProfile(profile);
        //THEN
        assertEquals(response.response(), handler.handle(query).response());
    }
    @Test
    void it_should_throw_an_exception_when_user_profile_does_not_exists(){
        //GIVEN
        UserProfileId id = UserProfileIdMother.random();

        FindUserProfileQuery query = FindUserProfileQueryMother.create(id.value());

        //WHEN
        shouldNotAnswerAnything(id);
        //THEN
        assertThrows(UserProfileNotFoundException.class, ()-> handler.handle(query));
    }
}
