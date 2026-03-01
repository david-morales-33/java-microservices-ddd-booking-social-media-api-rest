package com.dmx.social_graph.shared.domain.criteria;

import com.dmx.social_graph.shared.domain.WordMother;

public final class OrderByTest {
    public static OrderBy random(){
        return new OrderBy(WordMother.random());
    }
}
