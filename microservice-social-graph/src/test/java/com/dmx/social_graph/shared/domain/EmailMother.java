package com.dmx.social_graph.shared.domain;

public final class EmailMother {
    public static String random(){
        return TestCreator.random().internet().emailAddress();
    }
}
