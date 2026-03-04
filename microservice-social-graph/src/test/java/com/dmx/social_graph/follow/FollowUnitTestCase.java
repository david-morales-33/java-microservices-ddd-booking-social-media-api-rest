package com.dmx.social_graph.follow;

import com.dmx.social_graph.follow.domain.Follow;
import com.dmx.social_graph.follow.domain.FollowId;
import com.dmx.social_graph.follow.domain.FollowRepository;
import com.dmx.social_graph.shared.infrastructure.UnitTestCase;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

public class FollowUnitTestCase extends UnitTestCase {

    protected FollowRepository repository;

    @BeforeEach
    protected void setUp() {
        super.setUp();
        repository = mock(FollowRepository.class);
    }
    public void shouldAnswerAnyFollow(Follow follow) {
        when(repository.findById(follow.getId())).thenReturn(Optional.of(follow));
    }
    public void shouldNotAnswerAnything(FollowId id) {
        when(repository.findById(id)).thenReturn(Optional.empty());
    }
    public void shouldAnswerAnyFollowByUsers(Follow follow) {
        when(repository.findByUsers(follow.getUserId(), follow.getFollowerId())).thenReturn(Optional.of(follow));
    }
    public void shouldNotAnswerAnyFollowByUsers(Follow follow) {
        when(repository.findByUsers(follow.getUserId(), follow.getFollowerId())).thenReturn(Optional.empty());
    }
    public void shouldAnswerAnyActiveFollowByUsers(Follow follow) {
        when(repository.existsActiveFollow(follow.getFollowerId(), follow.getUserId())).thenReturn(true);
    }
    public void shouldNotAnswerAnyActiveFollowByUsers(Follow follow) {
        when(repository.existsActiveFollow(follow.getFollowerId(), follow.getUserId())).thenReturn(false);
    }

    public void shouldAnswerAnyListOfFollowers(Follow follow) {
        when(repository.findFollowersOf(follow.getUserId())).thenReturn(List.of(follow));
    }

    public void shouldAnswerAnyEmptyListOfFollowers(Follow follow) {
        when(repository.findFollowersOf(follow.getUserId())).thenReturn(List.of());
    }

    public void shouldAnswerAnyListOfFollowing(Follow follow) {
        when(repository.findFollowingOf(follow.getFollowerId())).thenReturn(List.of(follow));
    }

    public void shouldAnswerAnyEmptyListOfFollowing(Follow follow) {
        when(repository.findFollowingOf(follow.getFollowerId())).thenReturn(List.of());
    }

    public void shouldVerifyDeletedFollow(Follow follow) {
        verify(repository, atLeastOnce()).delete(follow);
    }

    public void shouldVerifySavedFollow(Follow follow) {
        verify(repository, atLeastOnce()).save(follow);
    }
}
