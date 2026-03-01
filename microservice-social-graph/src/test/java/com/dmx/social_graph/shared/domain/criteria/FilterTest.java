package com.dmx.social_graph.shared.domain.criteria;

import com.dmx.social_graph.shared.domain.criteria.FilterOperatorTest;

public final class FilterTest {
    public static Filter create(
            FilterField field,
            FilterOperator operator,
            FilterValue value
    ) {
        return new Filter(field, operator, value);
    }

    public static Filter random() {
        return create(FilterFieldTest.random(), FilterOperatorTest.random(), FilterValueTest.random());
    }
}
