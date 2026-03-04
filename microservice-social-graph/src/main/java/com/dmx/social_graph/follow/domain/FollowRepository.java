package com.dmx.social_graph.follow.domain;

import java.util.List;
import java.util.Optional;

public interface FollowRepository {

    Follow save(Follow follow);

    Optional<Follow> findById(FollowId id);

    Optional<Follow> findByUsers(UserId userId, UserId followerId);

    boolean existsActiveFollow(UserId followerId, UserId followeeId);

    List<Follow> findFollowersOf(UserId userId);

    List<Follow> findFollowingOf(UserId userId);

    void delete(Follow follow);
}
