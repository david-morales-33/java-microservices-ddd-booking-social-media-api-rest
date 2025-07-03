package com.dmx.profile.contact.domain;

import com.dmx.profile.shared.domain.StringValueObject;

public final class ContactContent extends StringValueObject {
    public ContactContent(String value) {
        super(value);
    }

    private ContactContent() {
        super(null);
    }
}
