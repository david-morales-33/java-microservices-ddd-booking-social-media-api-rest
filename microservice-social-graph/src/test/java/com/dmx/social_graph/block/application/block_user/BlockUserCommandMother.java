package com.dmx.social_graph.block.application.block_user;

public class BlockUserCommandMother {
    public static BlockUserCommand create(String userId, String blockedUserId) {
        return new BlockUserCommand(userId, blockedUserId);
    }
}
