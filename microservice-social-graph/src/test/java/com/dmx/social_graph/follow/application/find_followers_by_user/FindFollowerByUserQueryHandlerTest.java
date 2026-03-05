package com.dmx.social_graph.follow.application.find_followers_by_user;

import com.dmx.social_graph.follow.FollowUnitTestCase;
import com.dmx.social_graph.follow.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public final class FindFollowerByUserQueryHandlerTest extends FollowUnitTestCase {

    private FindFollowByUserQueryHandler handler;
    private FollowByUserFinder finder;

    @BeforeEach
    protected void setUp() {
        super.setUp();
        finder = new FollowByUserFinder(repository);
        handler = new FindFollowByUserQueryHandler(finder);
    }

    @Test
    void it_should_find_followers_for_a_user() {
        // GIVEN
        FollowerByUserResponse response = FollowerByUserResponseMother.random();
        UserId userId = new UserId(response.followers().get(0).userId());
        FindFollowerByUserQuery query = FindFollowerByUserQueryMother.create(userId.value());

        Follow follow = Follow.fromPrimitives(response.followers().get(0));
        // WHEN
        shouldAnswerAnyListOfFollowers(follow);

        // THEN
        assertEquals(response.followers().get(0), handler.handle(query).followers().get(0));
    }

    @Test
    void it_should_return_empty_list_when_no_followers() {
        // GIVEN
        Follow follower = FollowTest.random();
        UserId userId = follower.getUserId();
        FindFollowerByUserQuery query = FindFollowerByUserQueryMother.create(userId.value());

        // WHEN
        shouldAnswerAnyEmptyListOfFollowers(follower);
        FollowerByUserResponse response = handler.handle(query);

        // THEN
        assertNotNull(response);
        assertEquals(0, response.followers().size());
    }

    @Test
    void it_should_find_multiple_followers_for_a_user() {
        // GIVEN
        Follow follower1 = FollowTest.random();
        Follow follower2 = FollowTest.randomWithFavorite();
        UserId userId = follower1.getUserId();
        FindFollowerByUserQuery query = FindFollowerByUserQueryMother.create(userId.value());

        // WHEN
        when(repository.findFollowersOf(userId)).thenReturn(List.of(follower1, follower2));
        FollowerByUserResponse response = handler.handle(query);

        // THEN
        assertNotNull(response);
        assertEquals(2, response.followers().size());
    }
}


