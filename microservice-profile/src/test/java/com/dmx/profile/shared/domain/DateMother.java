package com.dmx.profile.shared.domain;

public final class DateMother {
    public static String random(){
        return  TestCreator.random().date().toString();
    }
}
