package com.dmx.profile.social_graph.domain;

import java.util.Objects;

public final class SocialGraph {
    private final SocialGraphId id;
    private final SocialGraphFollows follows;
    private final SocialGraphFollowers followers;
    private final SocialGraphMatches matches;
    private final SocialGraphRating rating;
    private final SocialGraphBloquedUsers bloquedUsers;
    private final SocialGraphMutedUsers mutedUsers;
    private final SocialGraphFavoriteUsers favoriteUsers;

    public SocialGraph(
            SocialGraphId id,
            SocialGraphFollows follows,
            SocialGraphFollowers followers,
            SocialGraphMatches matches,
            SocialGraphRating rating,
            SocialGraphBloquedUsers bloquedUsers,
            SocialGraphMutedUsers mutedUsers,
            SocialGraphFavoriteUsers favoriteUsers
    ) {
        this.id = id;
        this.follows = follows;
        this.followers = followers;
        this.matches = matches;
        this.rating = rating;
        this.bloquedUsers = bloquedUsers;
        this.mutedUsers = mutedUsers;
        this.favoriteUsers = favoriteUsers;
    }

    public SocialGraph() {
        this.id = null;
        this.follows = null;
        this.followers = null;
        this.matches = null;
        this.rating = null;
        this.bloquedUsers = null;
        this.mutedUsers = null;
        this.favoriteUsers = null;
    }

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

    public static SocialGraph fromPrimitives(SocialGraphDTO socialGraph) {
        return new SocialGraph(
                new SocialGraphId(socialGraph.id()),
                new SocialGraphFollows(socialGraph.follows()),
                new SocialGraphFollowers(socialGraph.followers()),
                new SocialGraphMatches(socialGraph.matches()),
                new SocialGraphRating(socialGraph.rating()),
                new SocialGraphBloquedUsers(socialGraph.bloquedUsers()),
                new SocialGraphMutedUsers(socialGraph.mutedUsers()),
                new SocialGraphFavoriteUsers(socialGraph.favoriteUsers())
        );
    }

    public SocialGraphDTO toPrimitives() {
        return new SocialGraphDTO(
                this.id.value(),
                this.follows.value(),
                this.followers.value(),
                this.matches.value(),
                this.rating.value(),
                this.bloquedUsers.value(),
                this.mutedUsers.value(),
                this.favoriteUsers.value()
        );
    }

    public SocialGraphId getId() {
        return id;
    }

    public SocialGraphFollows getFollows() {
        return follows;
    }

    public SocialGraphFollowers getFollowers() {
        return followers;
    }

    public SocialGraphMatches getMatches() {
        return matches;
    }

    public SocialGraphRating getRating() {
        return rating;
    }

    public SocialGraphBloquedUsers getBloquedUsers() {
        return bloquedUsers;
    }

    public SocialGraphMutedUsers getMutedUsers() {
        return mutedUsers;
    }

    public SocialGraphFavoriteUsers getFavoriteUsers() {
        return favoriteUsers;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SocialGraph that = (SocialGraph) o;
        return Objects.equals(id, that.id) && Objects.equals(follows, that.follows) && Objects.equals(followers, that.followers) && Objects.equals(matches, that.matches) && Objects.equals(rating, that.rating) && Objects.equals(bloquedUsers, that.bloquedUsers) && Objects.equals(mutedUsers, that.mutedUsers) && Objects.equals(favoriteUsers, that.favoriteUsers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, follows, followers, matches, rating, bloquedUsers, mutedUsers, favoriteUsers);
    }

    @Override
    public String toString() {
        return "SocialGraph{" +
                "id=" + id +
                ", follows=" + follows +
                ", followers=" + followers +
                ", matches=" + matches +
                ", rating=" + rating +
                ", bloquedUsers=" + bloquedUsers +
                ", mutedUsers=" + mutedUsers +
                ", favoriteUsers=" + favoriteUsers +
                '}';
    }
}
