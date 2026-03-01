package com.dmx.social_graph.shared.domain.criteria;

import com.dmx.social_graph.shared.domain.EnumMother;

public final class FilterOperatorTest {
    public static FilterOperator random(){
        return EnumMother.random(FilterOperator.class);
    }
}
