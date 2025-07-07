package com.dmx.profile.photo.domain;

import com.dmx.profile.shared.domain.UuidMother;

public final class PhotoIdMother {
    public static PhotoId create(String value) {
        return new PhotoId(value);
    }

    public static PhotoId random() {
        return new PhotoId(UuidMother.random());
    }
}
