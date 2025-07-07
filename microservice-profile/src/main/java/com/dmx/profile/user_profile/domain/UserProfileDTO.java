package com.dmx.profile.user_profile.domain;

import com.dmx.profile.contact.domain.ContactDTO;
import com.dmx.profile.location.domain.LocationDTO;
import com.dmx.profile.photo.domain.PhotoDTO;
import com.dmx.profile.role.domain.RoleDTO;
import com.dmx.profile.skill.domain.SkillDTO;
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
    private final String description;
    private final PhotoDTO photo;
    private final StatusDTO status;
    private final Map<String, SkillDTO> skillList;
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
            String description,
            PhotoDTO photo,
            StatusDTO status,
            Map<String, SkillDTO> skillList,
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
        this.description = description;
        this.photo = photo;
        this.status = status;
        this.skillList = skillList;
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
        this.description = builder.description;
        this.photo = builder.photo;
        this.status = builder.status;
        this.skillList = builder.skillList;
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
        private String description;
        private PhotoDTO photo;
        private StatusDTO status;
        private Map<String, SkillDTO> skillList;
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

        public Builder photho(PhotoDTO photo) {
            this.photo = photo;
            return this;
        }

        public Builder status(StatusDTO status) {
            this.status = status;
            return this;
        }

        public Builder description(String description) {
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

        public Builder skillList(Map<String, SkillDTO> skillList) {
            this.skillList = skillList;
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

    public String getDescription() {
        return description;
    }

    public PhotoDTO getPhoto() {
        return photo;
    }

    public StatusDTO getStatus() {
        return status;
    }

    public Map<String, SkillDTO> getSkillList() {
        return skillList;
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
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserProfileDTO that = (UserProfileDTO) o;
        return id.equals(that.id) &&
                name.equals(that.name) &&
                nickname.equals(that.nickname) &&
                email.equals(that.email) &&
                age.equals(that.age) &&
                gender.equals(that.gender) &&
                description.equals(that.description) &&
                photo.equals(that.photo) &&
                status.equals(that.status) &&
                skillList.equals(that.skillList) &&
                locationList.equals(that.locationList) &&
                contactList.equals(that.contactList) &&
                roleList.equals(that.roleList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, nickname, email, age, gender, description, photo, status, skillList, locationList, contactList, roleList);
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
                ", description='" + description + '\'' +
                ", photo=" + photo +
                ", status=" + status +
                ", skillList=" + skillList +
                ", locationList=" + locationList +
                ", contactList=" + contactList +
                ", roleList=" + roleList +
                '}';
    }
}
