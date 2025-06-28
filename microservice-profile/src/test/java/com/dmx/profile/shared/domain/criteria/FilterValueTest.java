package com.dmx.profile.shared.domain.criteria;

import com.dmx.profile.shared.domain.WordMother;

public final class FilterValueTest {
    public static FilterValue random() {
        return new FilterValue(WordMother.random());
    }
}
