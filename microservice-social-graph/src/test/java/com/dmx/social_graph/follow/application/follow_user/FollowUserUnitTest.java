package com.dmx.social_graph.follow.application.follow_user;

import com.dmx.social_graph.follow.FollowUnitTestCase;
import com.dmx.social_graph.follow.domain.Follow;
import com.dmx.social_graph.follow.domain.FollowTest;
import com.dmx.social_graph.follow.domain.UserFollowNotAllowedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public final class FollowUserUnitTest extends FollowUnitTestCase {

    FollowUserCommandHandler handler;

    @BeforeEach
    protected void setUp() {
        super.setUp();
        handler = new FollowUserCommandHandler(new UserFollower(repository));
    }

    @Test
    void it_should_follow_a_user() {
        //GIVEN
        Follow follow = FollowTest.random();
        FollowUserCommand command = FollowUserCommandMother.create(
                follow.getUserId().value(),
                follow.getFollowerId().value()
        );

        //WHEN
        shouldNotAnswerAnyActiveFollowByUsers(follow);
        handler.handle(command);

        //THEN
        shouldVerifySavedFollow(follow);
    }

    @Test
    void it_should_not_follow_a_user_if_already_following() {
        //GIVEN
        Follow follow = FollowTest.random();
        FollowUserCommand command = FollowUserCommandMother.create(
                follow.getUserId().value(),
                follow.getFollowerId().value()
        );

        //WHEN
        shouldAnswerAnyActiveFollowByUsers(follow);

        //THEN
        assertThrows(UserFollowNotAllowedException.class, () -> handler.handle(command));
    }
}
