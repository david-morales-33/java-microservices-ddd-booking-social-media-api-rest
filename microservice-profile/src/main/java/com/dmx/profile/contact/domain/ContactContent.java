package com.dmx.profile.contact.domain;

import com.dmx.profile.shared.domain.StringValueObject;

public class ContactContent extends StringValueObject {
    public ContactContent(String value) {
        super(value);
    }

    private ContactContent() {
        super(null);
    }
}
