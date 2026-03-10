package com.dmx.social_graph.follow.application.find_following_by_user;

import com.dmx.social_graph.follow.FollowUnitTestCase;
import com.dmx.social_graph.follow.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public final class FindFollowingByUserQueryHandlerTest extends FollowUnitTestCase {

    private FindFollowingByUserQueryHandler handler;
    private FollowingByUserFinder finder;

    @BeforeEach
    protected void setUp() {
        super.setUp();
        handler = new FindFollowingByUserQueryHandler(new FollowingByUserFinder(repository));
    }

    @Test
    void it_should_find_following_for_a_user() {
        // GIVEN
        FollowingByUserResponse response = FollowingByUserResponseMother.random();
        UserId userId = new UserId(response.getFollowing().get(0).followerId());
        FindFollowingByUserQuery query = FindFollowingByUserQueryMother.create(userId.value());

        Follow follow = Follow.fromPrimitives(response.getFollowing().get(0));
        // WHEN
        shouldAnswerAnyListOfFollowing(follow);

        // THEN
        assertEquals(response.getFollowing().get(0), handler.handle(query).getFollowing().get(0));
    }

    @Test
    void it_should_return_empty_list_when_no_following() {
        // GIVEN
        Follow follow = FollowTest.random();
        UserId userId = follow.getFollowerId();
        FindFollowingByUserQuery query = FindFollowingByUserQueryMother.create(userId.value());

        // WHEN
        shouldAnswerAnyEmptyListOfFollowing(follow);
        FollowingByUserResponse response = handler.handle(query);

        // THEN
        assertNotNull(response);
        assertEquals(0, response.getFollowing().size());
    }
}
