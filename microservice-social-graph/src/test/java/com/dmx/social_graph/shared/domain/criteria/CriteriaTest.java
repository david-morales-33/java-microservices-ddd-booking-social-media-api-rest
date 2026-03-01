package com.dmx.social_graph.shared.domain.criteria;

import com.dmx.social_graph.shared.domain.ListTest;
import com.dmx.social_graph.shared.domain.criteria.FilterSupplier;

import java.util.Optional;

public final class CriteriaTest {
    public static Criteria create(Filters filters, Order order, Optional<Integer> limit, Optional<Integer> offset) {
        return new Criteria(filters, order, limit, offset);
    }

    public static Criteria random() {
        Filters filters = new Filters(ListTest.random(new FilterSupplier()));
        Order order = OrderTest.random();
        Integer limit = LimitTest.radom();
        Integer offset = OffsetTest.random();
        return create(filters, order, Optional.of(limit), Optional.of(offset));
    }
}
