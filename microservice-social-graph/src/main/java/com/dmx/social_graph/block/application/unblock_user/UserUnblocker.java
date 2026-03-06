package com.dmx.social_graph.block.application.unblock_user;

import com.dmx.social_graph.block.domain.*;

public class UserUnblocker {
    private final BlockRepository repository;

    public UserUnblocker(BlockRepository repository) {
        this.repository = repository;
    }

    public void execute(UserId userId, UserId blockedId) {
        if (!repository.existsByUsers(userId, blockedId)) {
            throw new UserBlockNotAllowedException();
        }
        Block block = repository.findByUsers(userId, blockedId).orElseThrow();
        repository.delete(block);
    }
}
