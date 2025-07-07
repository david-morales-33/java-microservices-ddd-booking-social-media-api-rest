package com.dmx.profile.shared.domain;

public class UrlMother {
    public static String random(){
        return TestCreator.random().internet().url();
    }
}
