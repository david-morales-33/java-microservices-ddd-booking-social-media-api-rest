package com.dmx.profile.location.domain;

import com.dmx.profile.shared.domain.WordMother;

public final class LocationCountryMother {
    public static LocationCountry crete(String value) {
        return new LocationCountry(value);
    }
    public static LocationCountry random(){
        return new LocationCountry(WordMother.random());
    }
}
