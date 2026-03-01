package com.dmx.social_graph.shared.domain;

public final class IntegerMother {
    public static Integer random(){
        return TestCreator.random().number().numberBetween(10,100);
    }
}
