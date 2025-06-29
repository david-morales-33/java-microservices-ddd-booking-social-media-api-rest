package com.dmx.profile.status.domain;

public final class StatusMother {
    public static Status create(StatusId id, StatusLabel label) {
        return new Status(id, label);
    }

    public static Status random() {
        return new Status(StatusIdMother.random(), StatusLabelMother.random());
    }
}
