package com.dmx.profile.status.domain;

import com.dmx.profile.shared.domain.WordMother;

public final class StatusLabelMother {
    public static StatusLabel create(String value) {
        return new StatusLabel(value);
    }

    public static StatusLabel random() {
        return new StatusLabel(WordMother.random());
    }
}
