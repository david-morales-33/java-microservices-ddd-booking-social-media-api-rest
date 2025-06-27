package com.dmx.profile.shared.domain.criteria;

import com.dmx.profile.shared.domain.WordTest;

public final class OrderByTest {
    public static OrderBy random(){
        return new OrderBy(WordTest.random());
    }
}
