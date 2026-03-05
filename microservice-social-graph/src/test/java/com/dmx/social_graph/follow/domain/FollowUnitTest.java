package com.dmx.social_graph.follow.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public final class FollowUnitTest {

    @Test
    void it_should_mark_as_favorite() {
        //GIVEN
        Follow follow = FollowTest.random();

        //WHEN
        follow.markAsFavorite();

        //THEN
        assertTrue(follow.getFavorite().value());
    }

    @Test
    void it_should_remove_favorite() {
        //GIVEN
        Follow follow = FollowTest.randomWithFavorite();

        //WHEN
        follow.removeFavorite();

        //THEN
        assertFalse(follow.getFavorite().value());
    }

    @Test
    void it_mark_as_muted() {
        //GIVEN
        Follow follow = FollowTest.random();

        //WHEN
        follow.markAsMute();

        //THEN
        assertTrue(follow.getMuted().value());
    }

    @Test
    void it_should_unmute() {
        //GIVEN
        Follow follow = FollowTest.randomWithMuted();

        //WHEN
        follow.unmute();

        //THEN
        assertFalse(follow.getMuted().value());
    }
}
