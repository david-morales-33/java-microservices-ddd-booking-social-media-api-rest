package com.dmx.profile.status.domain;

import com.dmx.profile.shared.domain.StringValueObject;

public final class StatusLabel extends StringValueObject {
    public StatusLabel(String value) {
        super(value);
    }

    private StatusLabel() {
        super(null);
    }
}
