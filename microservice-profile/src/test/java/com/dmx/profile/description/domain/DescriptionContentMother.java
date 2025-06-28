package com.dmx.profile.description.domain;

import com.dmx.profile.shared.domain.WordMother;

public final class DescriptionContentMother {
    public static DescriptionContent create(String value) {
        return new DescriptionContent(value);
    }

    public static DescriptionContent random() {
        return new DescriptionContent(WordMother.random());
    }
}
