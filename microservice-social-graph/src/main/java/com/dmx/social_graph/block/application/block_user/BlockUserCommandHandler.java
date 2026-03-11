package com.dmx.social_graph.block.application.block_user;

import com.dmx.social_graph.block.domain.UserId;
import com.dmx.social_graph.shared.domain.Service;
import com.dmx.social_graph.shared.domain.bus.command.CommandHandler;

@Service
public class BlockUserCommandHandler implements CommandHandler<BlockUserCommand> {
    private final UserBlocker blocker;

    public BlockUserCommandHandler(UserBlocker blocker) {
        this.blocker = blocker;
    }

    @Override
    public void handle(BlockUserCommand command) {
        UserId userId = new UserId(command.getUserId());
        UserId blockedId = new UserId(command.getBlockedUserId());
        blocker.execute(userId, blockedId);
    }
}
