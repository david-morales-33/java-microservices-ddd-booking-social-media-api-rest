package com.dmx.social_graph.shared.domain.criteria;

import com.dmx.social_graph.shared.domain.WordMother;

public final class FilterFieldTest {
    public static FilterField random() {
        return new FilterField(WordMother.random());
    }
}
