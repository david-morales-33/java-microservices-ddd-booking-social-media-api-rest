package com.dmx.social_graph.block.domain;

public final class BlockTest {
    public static Block create(BlockId id, UserId userId, UserId blockedId) {
        return new Block(id, userId, blockedId, BlockInstant.now());
    }

    public static Block random() {
        return new Block(BlockIdTest.random(), UserIdTest.random(), UserIdTest.random(), BlockInstant.now());
    }
}
