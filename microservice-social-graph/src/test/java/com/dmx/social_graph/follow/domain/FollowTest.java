package com.dmx.social_graph.follow.domain;

public final class FollowTest {
    public static Follow create(FollowId id, UserId userId, UserId followerId) {
        return new Follow(id, userId, followerId);
    }

    public static Follow random() {
        return Follow.create(UserIdTest.random(), UserIdTest.random());
    }

    public static Follow randomWithFavorite() {
        Follow follow = Follow.create(UserIdTest.random(), UserIdTest.random());
        follow.markAsFavorite();
        return follow;
    }

    public static Follow randomWithMuted() {
        Follow follow = Follow.create(UserIdTest.random(), UserIdTest.random());
        follow.markAsMute();
        return follow;
    }

}


