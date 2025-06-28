package com.dmx.profile.contact.domain;

public final class ContactMother {
    public static Contact create(ContactId id, ContactContent content) {
        return new Contact(id, content);
    }

    public static Contact random() {
        return new Contact(ContactIdMother.random(), ContactContentMother.random());
    }
}
