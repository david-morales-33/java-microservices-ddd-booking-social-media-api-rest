package com.dmx.social_graph.follow.domain;

import java.util.List;
import java.util.Optional;

public interface FollowRepository {

    void save(Follow follow);

    boolean existsActiveFollow(UserId followerId, UserId followeeId);

    Optional<Follow> findByUsers(UserId userId, UserId followerId);

    List<Follow> findFollowersOf(UserId userId);

    List<Follow> findFollowingOf(UserId userId);

}
