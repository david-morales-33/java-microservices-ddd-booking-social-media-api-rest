package com.dmx.profile.shared.domain.criteria;

import com.dmx.profile.shared.domain.EnumMother;

public final class FilterOperatorTest {
    public static FilterOperator random(){
        return EnumMother.random(FilterOperator.class);
    }
}
