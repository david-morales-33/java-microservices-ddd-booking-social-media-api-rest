package com.dmx.profile.user_profile.domain;


import com.dmx.profile.contact.domain.ContactDTO;
import com.dmx.profile.description.domain.DescriptionDTO;
import com.dmx.profile.location.domain.LocationDTO;
import com.dmx.profile.role.domain.RoleDTO;
import com.dmx.profile.status.domain.StatusDTO;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

public final class UserProfileDTO implements Serializable {
    private final String id;
    private final String name;
    private final String nickname;
    private final String email;
    private final Integer age;
    private final String gender;
    private final StatusDTO status;
    private final DescriptionDTO description;
    private final Map<String, LocationDTO> locationList;
    private final Map<String, ContactDTO> contactList;
    private final Map<String, RoleDTO> roleList;

    public UserProfileDTO(
            String id,
            String name,
            String nickname,
            String email,
            Integer age,
            String gender,
            StatusDTO status,
            DescriptionDTO description,
            Map<String, LocationDTO> locationList,
            Map<String, ContactDTO> contactList,
            Map<String, RoleDTO> roleLis
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
        this.roleList = roleLis;
    }

    private UserProfileDTO(Builder builder) {
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
        private String id;
        private String name;
        private String nickname;
        private String email;
        private Integer age;
        private String gender;
        private StatusDTO status;
        private DescriptionDTO description;
        private Map<String, LocationDTO> locationList;
        private Map<String, ContactDTO> contactList;
        private Map<String, RoleDTO> roleList;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder nickname(String nickname) {
            this.nickname = nickname;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder age(Integer age) {
            this.age = age;
            return this;
        }

        public Builder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public Builder status(StatusDTO status) {
            this.status = status;
            return this;
        }

        public Builder description(DescriptionDTO description) {
            this.description = description;
            return this;
        }

        public Builder locationList(Map<String, LocationDTO> locationList) {
            this.locationList = locationList;
            return this;
        }

        public Builder contactList(Map<String, ContactDTO> contactList) {
            this.contactList = contactList;
            return this;
        }

        public Builder roleList(Map<String, RoleDTO> roleList) {
            this.roleList = roleList;
            return this;
        }

        public UserProfileDTO build() {
            return new UserProfileDTO(this);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNickname() {
        return nickname;
    }

    public String getEmail() {
        return email;
    }

    public Integer getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public StatusDTO getStatus() {
        return status;
    }

    public DescriptionDTO getDescription() {
        return description;
    }

    public Map<String, LocationDTO> getLocationList() {
        return locationList;
    }

    public Map<String, ContactDTO> getContactList() {
        return contactList;
    }

    public Map<String, RoleDTO> getRoleList() {
        return roleList;
    }

    @Override
    public String toString() {
        return "UserProfileDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", status=" + status +
                ", description=" + description +
                ", locationList=" + locationList +
                ", contactList=" + contactList +
                ", roleList=" + roleList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserProfileDTO that = (UserProfileDTO) o;
        return id.equals(that.id) &&
                name.equals(that.name) &&
                nickname.equals(that.nickname) &&
                email.equals(that.email) &&
                age.equals(that.age) &&
                gender.equals(that.gender) &&
                status.equals(that.status) &&
                description.equals(that.description) &&
                locationList.equals(that.locationList) &&
                contactList.equals(that.contactList) &&
                roleList.equals(that.roleList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, nickname, email, age, gender, status, description, locationList, contactList, roleList);
    }
}
