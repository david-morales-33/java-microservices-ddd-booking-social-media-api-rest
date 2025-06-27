package com.dmx.profile.contact.domain;

import com.dmx.profile.shared.domain.Identifier;

public class ContactId extends Identifier {
    public ContactId(String value) {
        super(value);
    }

    private ContactId() {
    }
}
