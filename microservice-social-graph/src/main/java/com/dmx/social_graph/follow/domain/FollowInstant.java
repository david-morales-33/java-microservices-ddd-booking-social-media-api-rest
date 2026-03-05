package com.dmx.social_graph.follow.domain;

import com.dmx.social_graph.shared.domain.StringValueObject;
import com.dmx.social_graph.shared.domain.Utils;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class FollowInstant extends StringValueObject {
    public FollowInstant(String value) {
        super(value);
    }

    public static String dateToString(LocalDateTime dateTime) {
        return Utils.dateToString(dateTime);
    }

    public static String dateToString(Timestamp timestamp) {
        return Utils.dateToString(timestamp);
    }

    public static FollowInstant now() {
        LocalDateTime now = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(now);
        return new FollowInstant(dateToString(timestamp));
    }
}
