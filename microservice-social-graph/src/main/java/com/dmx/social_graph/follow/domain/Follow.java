package com.dmx.social_graph.follow.domain;

import java.util.Objects;

public class Follow {
    private final FollowId id;
    private final UserId userId;
    private final UserId followerId;
    private final FollowInstant createdAt;
    private FollowInstant updatedAt;
    private FollowFavorite favorite;
    private FollowMuted muted;

    public Follow(FollowId id, UserId userId, UserId followerId) {
        if (userId.equals(followerId)) {
            throw new UserFollowThemselvesExecption(followerId);
        }
        this.id = id;
        this.followerId = followerId;
        this.userId = userId;
        this.createdAt = FollowInstant.now();
        this.updatedAt = FollowInstant.now();
    }

    private Follow() {
        this.id = null;
        this.followerId = null;
        this.userId = null;
        this.createdAt = null;
    }

    public Follow(FollowId id, UserId userId, UserId followerId, FollowFavorite favorite, FollowMuted muted) {
        if (userId.equals(followerId)) {
            throw new UserFollowThemselvesExecption(followerId);
        }
        this.id = id;
        this.followerId = followerId;
        this.userId = userId;
        this.createdAt = FollowInstant.now();
        this.updatedAt = FollowInstant.now();
        this.favorite = favorite;
        this.muted = muted;
    }

    public static Follow create(UserId userId, UserId followerId) {
        return new Follow(
                new FollowId(FollowId.generate()),
                userId,
                followerId,
                FollowFavorite.of(false),
                FollowMuted.of(false)
        );
    }


    public void markAsFavorite() {
        this.favorite = FollowFavorite.of(true);
        this.updatedAt = FollowInstant.now();
    }

    public void removeFavorite() {
        this.favorite = FollowFavorite.of(false);
        this.updatedAt = FollowInstant.now();
    }

    public void markAsMute() {
        this.muted = FollowMuted.of(true);
        this.updatedAt = FollowInstant.now();
    }

    public void unmute() {
        this.muted = FollowMuted.of(false);
        this.updatedAt = FollowInstant.now();
    }

    public FollowId getId() {
        return id;
    }

    public UserId getUserId() {
        return userId;
    }

    public UserId getFollowerId() {
        return followerId;
    }


    public FollowInstant getCreatedAt() {
        return createdAt;
    }

    public FollowInstant getUpdatedAt() {
        return updatedAt;
    }

    public FollowFavorite getFavorite() {
        return favorite;
    }

    public FollowMuted getMuted() {
        return muted;
    }

    public FollowDTO toPrimitives() {
        return new FollowDTO(
                this.id.value(),
                this.userId.value(),
                this.followerId.value(),
                FollowInstant.dateToString(java.time.LocalDateTime.now()),
                FollowInstant.dateToString(java.time.LocalDateTime.now()),
                this.favorite.value(),
                this.muted.value()
        );
    }

    public static Follow fromPrimitives(FollowDTO dto) {
        return new Follow(
                new FollowId(dto.id()),
                new UserId(dto.userId()),
                new UserId(dto.followerId()),
                FollowFavorite.of(dto.favorite()),
                FollowMuted.of(dto.muted())
        );

    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Follow follow = (Follow) o;
        return userId.equals(follow.userId) &&
                followerId.equals(follow.followerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, followerId);
    }
}
