package com.dmx.profile.shared.domain;

public final class EmailMother {
    public static String random(){
        return TestCreator.random().internet().emailAddress();
    }
}
