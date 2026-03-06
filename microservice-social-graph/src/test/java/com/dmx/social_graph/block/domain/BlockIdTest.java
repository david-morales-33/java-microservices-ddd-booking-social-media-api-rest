package com.dmx.social_graph.block.domain;

import com.dmx.social_graph.shared.domain.UuidMother;

public final class BlockIdTest {
    public static BlockId create(String value) {
        return new BlockId(value);
    }

    public static BlockId random() {
        return new BlockId(UuidMother.random());
    }
}
