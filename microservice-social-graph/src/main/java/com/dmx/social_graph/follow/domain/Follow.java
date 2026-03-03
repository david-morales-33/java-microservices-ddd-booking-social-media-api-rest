package com.dmx.social_graph.follow.domain;

import java.util.Objects;

public class Follow {

    private final FollowId id;
    private final UserId userId;
    private final UserId followerId;
    private FollowStatus status;
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

    public static Follow create(UserId userId, UserId followerId) {
        return new Follow(new FollowId(FollowId.generate()), userId, followerId);
    }

    public void unfollow() {
        if (this.status == FollowStatus.UNFOLLOWED) {
            throw new UnfollowException();
        }
        this.status = FollowStatus.UNFOLLOWED;
        this.updatedAt = FollowInstant.now();
    }

    public void reactivate() {
        if (this.status == FollowStatus.BLOCKED) {
            throw new ReactiveException();
        }
        this.status = FollowStatus.ACTIVE;
        this.updatedAt = FollowInstant.now();
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

    public void block() {
        this.status = FollowStatus.BLOCKED;
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

    public FollowStatus getStatus() {
        return status;
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Follow follow = (Follow) o;
        return id.equals(follow.id) &&
                userId.equals(follow.userId) &&
                followerId.equals(follow.followerId) &&
                status.equals(follow.status) &&
                createdAt.equals(follow.createdAt) &&
                updatedAt.equals(follow.updatedAt) &&
                favorite.equals(follow.favorite) &&
                muted.equals(follow.muted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, followerId, status, createdAt, updatedAt, favorite, muted);
    }
}
