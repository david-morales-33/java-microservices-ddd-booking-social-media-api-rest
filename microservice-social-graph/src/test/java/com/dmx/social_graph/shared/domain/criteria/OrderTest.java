package com.dmx.social_graph.shared.domain.criteria;

import com.dmx.social_graph.shared.domain.criteria.OrderTypeTest;

public final class OrderTest {
    public static Order create(OrderBy orderBy, OrderType orderType) {
        return new Order(orderBy, orderType);
    }

    public static Order random() {
        return create(OrderByTest.random(), OrderTypeTest.random());
    }
}
