package com.dmx.profile.contact.domain;

import com.dmx.profile.shared.domain.EmailMother;

public final class ContactContentMother {
    public static ContactContent create(String value) {
        return new ContactContent(value);
    }

    public static ContactContent random() {
        return new ContactContent(EmailMother.random());
    }
}
