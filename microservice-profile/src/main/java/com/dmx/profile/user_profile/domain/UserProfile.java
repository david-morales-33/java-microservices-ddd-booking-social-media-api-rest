package com.dmx.profile.user_profile.domain;

import com.dmx.profile.contact.domain.Contact;
import com.dmx.profile.contact.domain.ContactDTO;
import com.dmx.profile.description.domain.Description;
import com.dmx.profile.location.domain.Location;
import com.dmx.profile.location.domain.LocationDTO;
import com.dmx.profile.role.domain.Role;
import com.dmx.profile.role.domain.RoleDTO;
import com.dmx.profile.shared.domain.AggregateRoot;
import com.dmx.profile.status.domain.Status;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class UserProfile extends AggregateRoot {
    private final UserProfileId id;
    private final UserProfileName name;
    private final UserProfileNickname nickname;
    private final UserProfileEmail email;
    private final UserProfileAge age;
    private final UserProfileGender gender;
    private final Status status;
    private final Description description;
    private Map<String, Location> locationList;
    private Map<String, Contact> contactList;
    private Map<String, Role> roleList;

    public UserProfile(
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
        this.id = id;
        this.name = name;
        this.nickname = nickname;
        this.email = email;
        this.age = age;
        this.gender = gender;
        this.status = status;
        this.description = description;
        this.locationList = locationList;
        this.contactList = contactList;
        this.roleList = roleList;
    }

    public UserProfile() {
        this.id = null;
        this.name = null;
        this.nickname = null;
        this.email = null;
        this.age = null;
        this.gender = null;
        this.status = null;
        this.description = null;
        this.locationList = new HashMap<>();
        this.contactList = new HashMap<>();
        this.roleList = new HashMap<>();
    }

    private UserProfile(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.nickname = builder.nickname;
        this.email = builder.email;
        this.age = builder.age;
        this.gender = builder.gender;
        this.status = builder.status;
        this.description = builder.description;
        this.locationList = builder.locationList;
        this.contactList = builder.contactList;
        this.roleList = builder.roleList;
    }

    public static class Builder {
        private UserProfileId id;
        private UserProfileName name;
        private UserProfileNickname nickname;
        private UserProfileEmail email;
        private UserProfileAge age;
        private UserProfileGender gender;
        private Status status;
        private Description description;
        private Map<String, Location> locationList = new HashMap<>();
        private Map<String, Contact> contactList = new HashMap<>();
        private Map<String, Role> roleList = new HashMap<>();

        public Builder id(String id) {
            this.id = new UserProfileId(id);
            return this;
        }

        public Builder name(String name) {
            this.name = new UserProfileName(name);
            return this;
        }

        public Builder nickname(String nickname) {
            this.nickname = new UserProfileNickname(nickname);
            return this;
        }

        public Builder email(String email) {
            this.email = new UserProfileEmail(email);
            return this;
        }

        public Builder age(int age) {
            this.age = new UserProfileAge(age);
            return this;
        }

        public Builder gender(String gender) {
            this.gender = new UserProfileGender(gender);
            return this;
        }

        public Builder status(Status status) {
            this.status = status;
            return this;
        }

        public Builder description(Description description) {
            this.description = description;
            return this;
        }

        public Builder addLocation(String key, Location location) {
            this.locationList.put(key, location);
            return this;
        }

        public Builder addContact(String key, Contact contact) {
            this.contactList.put(key, contact);
            return this;
        }

        public Builder addRole(String key, Role role) {
            this.roleList.put(key, role);
            return this;
        }

        public UserProfile build() {

            return new UserProfile(this);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

        public static UserProfile fromPrimitives(UserProfileDTO userProfile) {
        HashMap<String, Location> locationList = new HashMap<>();
        HashMap<String, Contact> contactList = new HashMap<>();
        HashMap<String, Role> roleList = new HashMap<>();

        userProfile.getLocationList().forEach((key, location) -> locationList.put(key, Location.fromPrimitives(location)));
        userProfile.getContactList().forEach((value, contact) -> contactList.put(value, Contact.fromPrimitives(contact)));
        userProfile.getRoleList().forEach((key, role) -> roleList.put(key, Role.fromPrimitives(role)));

        return new UserProfile(
                new UserProfileId(userProfile.getId()),
                new UserProfileName(userProfile.getName()),
                new UserProfileNickname(userProfile.getNickname()),
                new UserProfileEmail(userProfile.getEmail()),
                new UserProfileAge(userProfile.getAge()),
                new UserProfileGender(userProfile.getGender()),
                Status.fromPrimitives(userProfile.getStatus()),
                Description.fromPrimitives(userProfile.getDescription()),
                locationList,
                contactList,
                roleList
        );
    }

    public UserProfileDTO toPrimitives() {
        HashMap<String, LocationDTO> locationList = new HashMap<>();
        HashMap<String, ContactDTO> contactList = new HashMap<>();
        HashMap<String, RoleDTO> roleList = new HashMap<>();
        this.locationList.forEach((key, location) -> locationList.put(key, location.toPrimitives()));
        this.contactList.forEach((key, contact) -> contactList.put(key, contact.toPrimitive()));
        this.roleList.forEach((key, role) -> roleList.put(key, role.toPrimitives()));
        return new UserProfileDTO(
                this.id.value(),
                this.name.value(),
                this.nickname.value(),
                this.email.value(),
                this.age.value(),
                this.gender.value(),
                this.status.toPrimitives(),
                this.description.toPrimitives(),
                locationList,
                contactList,
                roleList
        );
    }


    public UserProfileId getId() {
        return id;
    }

    public UserProfileName getName() {
        return name;
    }

    public UserProfileNickname getNickname() {
        return nickname;
    }

    public UserProfileEmail getEmail() {
        return email;
    }

    public UserProfileAge getAge() {
        return age;
    }

    public UserProfileGender getGender() {
        return gender;
    }

    public Status getStatus() {
        return status;
    }

    public Description getDescription() {
        return description;
    }

    public Map<String, Location> getLocationList() {
        return locationList;
    }

    public void setLocationList(Map<String, Location> locationList) {
        this.locationList = locationList;
    }

    public Map<String, Contact> getContactList() {
        return contactList;
    }

    public void setContactList(Map<String, Contact> contactList) {
        this.contactList = contactList;
    }

    public Map<String, Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(Map<String, Role> roleList) {
        this.roleList = roleList;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserProfile that = (UserProfile) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(nickname, that.nickname) &&
                Objects.equals(email, that.email) &&
                Objects.equals(age, that.age) &&
                Objects.equals(gender, that.gender) &&
                Objects.equals(status, that.status) &&
                Objects.equals(description, that.description) &&
                Objects.equals(locationList, that.locationList) &&
                Objects.equals(contactList, that.contactList) &&
                Objects.equals(roleList, that.roleList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, nickname, email, age, gender, status, description, locationList, contactList, roleList);
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "id=" + id +
                ", name=" + name +
                ", nickname=" + nickname +
                ", email=" + email +
                ", age=" + age +
                ", gender=" + gender +
                ", status=" + status +
                ", description=" + description +
                ", locationList=" + locationList +
                ", contactList=" + contactList +
                ", roleList=" + roleList +
                '}';
    }
}
