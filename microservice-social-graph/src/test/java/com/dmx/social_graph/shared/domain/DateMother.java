package com.dmx.social_graph.shared.domain;

public final class DateMother {
    public static String random(){
        return  TestCreator.random().date().toString();
    }
}
