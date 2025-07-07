package com.dmx.profile.photo.domain;

public final class PhotoMother {
    public static Photo create(PhotoId id, PhotoUrl url) {
        return new Photo(id, url);
    }

    public static Photo random() {
        return new Photo(PhotoIdMother.random(), PhotoUrlMother.random());
    }
}
