package com.dmx.profile.user_profile;

import com.dmx.profile.shared.domain.criteria.Criteria;
import com.dmx.profile.shared.infrastructure.UnitTestCase;
import com.dmx.profile.user_profile.domain.UserProfile;
import com.dmx.profile.user_profile.domain.UserProfileId;
import com.dmx.profile.user_profile.domain.UserProfileRepository;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

public abstract class UserProfileUnitCaseTest extends UnitTestCase {

    protected UserProfileRepository repository;

    @BeforeEach
    protected void setUp() {
        super.setUp();
        repository = mock(UserProfileRepository.class);
    }

    public void shouldAnswerAnyUserProfile(UserProfile profile) {
        when(repository.find(profile.getId())).thenReturn(Optional.of(profile));
    }

    public void shouldNotAnswerAnything(UserProfileId id) {
        when(repository.find(id)).thenReturn(Optional.empty());
    }

    public void shouldAnswerAnyList(List<UserProfile> profileList, Criteria criteria) {
        when(repository.match(criteria)).thenReturn(profileList);
    }
    public void shouldAnswerAnEmptyList(Criteria criteria) {
        when(repository.match(criteria)).thenReturn(new ArrayList<>());
    }

    public void shouldVerifySavedUserProfile(UserProfile profile) {
        verify(repository, atLeastOnce()).save(profile);
    }

}
