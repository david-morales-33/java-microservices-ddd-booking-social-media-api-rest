package com.dmx.profile.contact.domain;

import com.dmx.profile.shared.domain.UuidMother;

public final class ContactIdMother {

    public static ContactId create(String value) {
        return new ContactId(value);
    }

    public static ContactId random() {
        return new ContactId(UuidMother.random());
    }
}
