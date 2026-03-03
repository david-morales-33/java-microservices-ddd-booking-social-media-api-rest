package com.dmx.social_graph.follow.domain;

import com.dmx.social_graph.shared.domain.Utils;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class FollowInstant{
    public FollowInstant() {
    }

    public static String dateToString(LocalDateTime dateTime) {
        return Utils.dateToString(dateTime);
    }

    public static String dateToString(Timestamp timestamp) {
        return Utils.dateToString(timestamp);
    }

    public static FollowInstant now() {
        return new FollowInstant();
    }
}
