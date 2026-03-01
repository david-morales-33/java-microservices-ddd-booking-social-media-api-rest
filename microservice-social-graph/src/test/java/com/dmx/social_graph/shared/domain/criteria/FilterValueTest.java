package com.dmx.social_graph.shared.domain.criteria;

import com.dmx.social_graph.shared.domain.WordMother;

public final class FilterValueTest {
    public static FilterValue random() {
        return new FilterValue(WordMother.random());
    }
}
