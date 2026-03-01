package com.dmx.social_graph.shared.domain;

import com.dmx.social_graph.shared.domain.TestCreator;

public final class FloatMother {
    public static Float random() {
        return (float) TestCreator.random().number().numberBetween(0, 100) / 100;
    }
}
