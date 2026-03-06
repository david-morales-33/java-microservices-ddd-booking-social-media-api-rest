package com.dmx.social_graph.block.domain;

import com.dmx.social_graph.shared.domain.StringValueObject;
import com.dmx.social_graph.shared.domain.Utils;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public final class BlockInstant extends StringValueObject {
    public BlockInstant(String id) {
        super(id);
    }

    public static String dateToString(LocalDateTime dateTime) {
        return Utils.dateToString(dateTime);
    }

    public static String dateToString(Timestamp timestamp) {
        return Utils.dateToString(timestamp);
    }

    public static BlockInstant now() {
        LocalDateTime now = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(now);
        return new BlockInstant(dateToString(timestamp));
    }
}
