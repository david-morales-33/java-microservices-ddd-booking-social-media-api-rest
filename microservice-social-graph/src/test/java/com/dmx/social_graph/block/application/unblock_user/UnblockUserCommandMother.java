package com.dmx.social_graph.block.application.unblock_user;

public class UnblockUserCommandMother {
    public static UnblockUserCommand create(String userId, String blockedUserId) {
        return new UnblockUserCommand(userId, blockedUserId);
    }
}
