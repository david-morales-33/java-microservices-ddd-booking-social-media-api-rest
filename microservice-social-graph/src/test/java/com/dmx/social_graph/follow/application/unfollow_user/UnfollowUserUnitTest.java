package com.dmx.social_graph.follow.application.unfollow_user;

import com.dmx.social_graph.follow.FollowUnitTestCase;
import com.dmx.social_graph.follow.domain.Follow;
import com.dmx.social_graph.follow.domain.FollowDoesNotExistException;
import com.dmx.social_graph.follow.domain.FollowTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public final class UnfollowUserUnitTest extends FollowUnitTestCase {

    UnfollowUserCommandHandler handler;

    @BeforeEach
    protected void setUp() {
        super.setUp();
        handler = new UnfollowUserCommandHandler(new UserUnfollower(repository));
    }

    @Test
    void it_should_unfollow_a_user() {
        //GIVEN
        Follow follow = FollowTest.random();

        UnfollowUserCommand command = UnfollowUserCommandMother.create(
                follow.getUserId().value(),
                follow.getFollowerId().value()
        );

        //WHEN
        handler.handle(command);

        //THEN
        shouldAnswerAnyFollowByUsers(follow);
        shouldVerifySavedFollow(follow);
    }

    @Test
    void it_should_not_unfollow_a_user_if_not_following() {
        //GIVEN
        Follow follow = FollowTest.random();

        UnfollowUserCommand command = UnfollowUserCommandMother.create(
                follow.getUserId().value(),
                follow.getFollowerId().value()
        );

        //WHEN
        shouldNotAnswerAnyFollowByUsers(follow);

        //THEN
        assertThrows(FollowDoesNotExistException.class, () -> handler.handle(command));
    }

}
