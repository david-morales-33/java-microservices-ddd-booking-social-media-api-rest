package com.dmx.profile.shared.domain.criteria;

import com.dmx.profile.shared.domain.WordMother;

public final class OrderByTest {
    public static OrderBy random(){
        return new OrderBy(WordMother.random());
    }
}
