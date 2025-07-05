package com.dmx.profile.photo.domain;

import com.dmx.profile.shared.domain.Identifier;

public class PhotoId extends Identifier {
    public PhotoId(String value) {
        super(value);
    }

    private PhotoId() {
    }
}
