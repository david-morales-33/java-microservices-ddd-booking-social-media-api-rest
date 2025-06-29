package com.dmx.profile.social_graph.domain;

public final class SocialGraphMother {
    public static SocialGraph create(
            SocialGraphId id,
            SocialGraphFollows follows,
            SocialGraphFollowers followers,
            SocialGraphMatches matches,
            SocialGraphRating rating,
            SocialGraphBloquedUsers bloquedUsers,
            SocialGraphMutedUsers mutedUsers,
            SocialGraphFavoriteUsers favoriteUsers
    ) {
        return new SocialGraph(id, follows, followers, matches, rating, bloquedUsers, mutedUsers, favoriteUsers);
    }

    public static SocialGraph random() {
        return new SocialGraph(
                SocialGraphIdMother.random(),
                SocialGraphFollowsMother.random(),
                SocialGraphFollowersMother.random(),
                SocialGraphMatchesMother.random(),
                SocialGraphRatingMother.random(),
                SocialGraphBloquedUsersMother.random(),
                SocialGraphMutedUsersMother.random(),
                SocialGraphFavoriteUsersMother.random()
        );
    }
}
