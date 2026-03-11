package com.dmx.social_graph.block.application.unblock_user;

import com.dmx.social_graph.block.domain.UserId;
import com.dmx.social_graph.shared.domain.Service;
import com.dmx.social_graph.shared.domain.bus.command.CommandHandler;

@Service
public class UnblockUserCommandHandler implements CommandHandler<UnblockUserCommand> {
    private final UserUnblocker unblocker;

    public UnblockUserCommandHandler(UserUnblocker unblocker) {
        this.unblocker = unblocker;
    }

    @Override
    public void handle(UnblockUserCommand command) {
        UserId userId = new UserId(command.getUserId());
        UserId blockedId = new UserId(command.getBlockedUserId());
        unblocker.execute(userId, blockedId);
    }
}
