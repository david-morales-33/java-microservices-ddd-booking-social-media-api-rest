package com.dmx.social_graph.block.application.block_user;

import com.dmx.social_graph.block.domain.*;
import com.dmx.social_graph.shared.domain.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserBlocker {
    private final BlockRepository repository;

    public UserBlocker(BlockRepository repository) {
        this.repository = repository;
    }

    @Transactional("social_graph-transaction_manager")
    public void execute(UserId userId, UserId blockedId) {
        if (repository.existsByUsers(userId, blockedId)) {
            throw new UserBlockNotAllowedException();
        }
        BlockId blockId = new BlockId(BlockId.generate());
        Block newBlock = Block.create(blockId, userId, blockedId);
        repository.save(newBlock);
    }
}
