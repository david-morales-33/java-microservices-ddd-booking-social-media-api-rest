package com.dmx.profile.photo.domain;

import java.io.Serializable;
import java.util.Objects;

public final class Photo implements Serializable {
    private final PhotoId id;
    private final PhotoUrl url;

    public Photo(PhotoId id, PhotoUrl url) {
        this.id = id;
        this.url = url;
    }

    public Photo() {
        this.id = null;
        this.url = null;
    }

    public PhotoId getId() {
        return id;
    }

    public PhotoUrl getUrl() {
        return url;
    }

    public static Photo fromPrimitives(PhotoDTO photo) {
        return new Photo(new PhotoId(photo.id()), new PhotoUrl(photo.url()));
    }

    public PhotoDTO toPrimitives() {
        return new PhotoDTO(this.id.value(), this.url.value());
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Photo photo = (Photo) o;
        return Objects.equals(id, photo.id) && Objects.equals(url, photo.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, url);
    }
}
