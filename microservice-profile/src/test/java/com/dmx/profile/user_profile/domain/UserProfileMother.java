package com.dmx.profile.user_profile.domain;

import com.dmx.profile.contact.domain.Contact;
import com.dmx.profile.contact.domain.ContactMother;
import com.dmx.profile.description.domain.Description;
import com.dmx.profile.description.domain.DescriptionMother;
import com.dmx.profile.location.domain.Location;
import com.dmx.profile.location.domain.LocationMother;
import com.dmx.profile.role.domain.Role;
import com.dmx.profile.role.domain.RoleTest;
import com.dmx.profile.status.domain.Status;
import com.dmx.profile.status.domain.StatusMother;

import java.util.HashMap;
import java.util.Map;

public final class UserProfileMother {
    public static UserProfile create(
            UserProfileId id,
            UserProfileName name,
            UserProfileNickname nickname,
            UserProfileEmail email,
            UserProfileAge age,
            UserProfileGender gender,
            Status status,
            Description description,
            Map<String, Location> locationList,
            Map<String, Contact> contactList,
            Map<String, Role> roleList
    ) {
        return new UserProfile(id, name, nickname, email, age, gender, status, description, locationList, contactList, roleList);
    }

    public static UserProfile random() {
        HashMap<String, Location> locationList = new HashMap<>();
        HashMap<String, Contact> contactList = new HashMap<>();
        HashMap<String, Role> roleList = new HashMap<>();
        for (int i = 0; i < 2; i++) {
            Location location = LocationMother.random();
            locationList.put(location.getId().value(), location);
        }
        for (int i = 0; i < 2; i++) {
            Contact contact = ContactMother.random();
            contactList.put(contact.getId().value(), contact);
        }
        for (int i = 0; i < 2; i++) {
            Role role = RoleTest.random();
            roleList.put(role.getId().value(), role);
        }
        return new UserProfile(
                UserProfileIdMother.random(),
                UserProfileNameMother.random(),
                UserProfileNicknameMother.random(),
                UserProfileEmailMother.random(),
                UserProfileAgeMother.random(),
                UserProfileGenderMother.random(),
                StatusMother.random(),
                DescriptionMother.random(),
                locationList,
                contactList,
                roleList
        );
    }
}
