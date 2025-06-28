package com.dmx.profile.shared.domain.criteria;

import com.dmx.profile.shared.domain.WordMother;

public final class FilterFieldTest {
    public static FilterField random() {
        return new FilterField(WordMother.random());
    }
}
