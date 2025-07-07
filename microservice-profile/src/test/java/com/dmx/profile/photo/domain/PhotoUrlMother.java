package com.dmx.profile.photo.domain;

import com.dmx.profile.shared.domain.UrlMother;

public final class PhotoUrlMother {
    public static PhotoUrl create(String value) {
        return new PhotoUrl(value);
    }

    public static PhotoUrl random() {
        return new PhotoUrl(UrlMother.random());
    }
}
