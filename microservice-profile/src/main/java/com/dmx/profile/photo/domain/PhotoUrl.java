package com.dmx.profile.photo.domain;

import com.dmx.profile.shared.domain.StringValueObject;

public final class PhotoUrl extends StringValueObject {
    public PhotoUrl(String value) {
        super(value);
    }

    private PhotoUrl() {
        super(null);
    }
}
