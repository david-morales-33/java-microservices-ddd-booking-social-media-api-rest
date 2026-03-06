package com.dmx.social_graph.block.domain;

public interface BlockRepository {
    void save(Block block);

    void delete(Block block);

    boolean existsByUsers(UserId userId, UserId blockedId);
}
