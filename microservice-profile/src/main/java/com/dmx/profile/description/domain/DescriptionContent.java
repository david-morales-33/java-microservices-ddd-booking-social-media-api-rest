package com.dmx.profile.description.domain;

import com.dmx.profile.shared.domain.StringValueObject;

public final class DescriptionContent extends StringValueObject {
    public DescriptionContent(String value) {
        super(value);
    }

    private DescriptionContent() {
        super(null);
    }
}
