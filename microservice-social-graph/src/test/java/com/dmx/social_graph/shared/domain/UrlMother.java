package com.dmx.social_graph.shared.domain;

import com.dmx.social_graph.shared.domain.TestCreator;

public class UrlMother {
    public static String random(){
        return TestCreator.random().internet().url();
    }
}
