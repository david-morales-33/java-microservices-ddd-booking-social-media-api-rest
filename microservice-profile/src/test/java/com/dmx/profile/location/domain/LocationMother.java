package com.dmx.profile.location.domain;

public final class LocationMother {
    public static Location create(LocationId id, LocationAddress address, LocationCountry country, LocationCity city) {
        return new Location(id, country, city, address);
    }

    public static Location random() {
        return new Location(
                LocationIdMother.random(),
                LocationCountryMother.random(),
                LocationCityMother.random(),
                LocationAddressMother.random()
        );
    }
}
