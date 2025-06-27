package com.dmx.profile.shared.domain.criteria;

import com.dmx.profile.shared.domain.EnumTest;

public final class FilterOperatorTest {
    public static FilterOperator random(){
        return EnumTest.random(FilterOperator.class);
    }
}
