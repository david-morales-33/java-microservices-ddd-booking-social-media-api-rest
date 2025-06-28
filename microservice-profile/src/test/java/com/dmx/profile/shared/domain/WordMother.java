package com.dmx.profile.shared.domain;

public final class WordMother {
    public static String random(){
        return TestCreator.random().lorem().word();
    }
}
