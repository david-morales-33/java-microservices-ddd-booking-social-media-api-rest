package com.dmx.profile.user_profile.domain;

import com.dmx.profile.contact.domain.Contact;
import com.dmx.profile.contact.domain.ContactDTO;
import com.dmx.profile.location.domain.Location;
import com.dmx.profile.location.domain.LocationDTO;
import com.dmx.profile.photo.domain.Photo;
import com.dmx.profile.photo.domain.PhotoDTO;
import com.dmx.profile.role.domain.Role;
import com.dmx.profile.role.domain.RoleDTO;
import com.dmx.profile.shared.domain.AggregateRoot;
import com.dmx.profile.skill.domain.Skill;
import com.dmx.profile.skill.domain.SkillDTO;
import com.dmx.profile.status.domain.Status;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public final class UserProfile extends AggregateRoot {
    private final UserProfileId id;
    private final UserProfileName name;
    private final UserProfileNickname nickname;
    private final UserProfileEmail email;
    private final UserProfileAge age;
    private final UserProfileGender gender;
    private final UserProfileDescription description;
    private Photo photo;
    private Status status;
    private Map<String, Skill> skillList;
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
            UserProfileDescription description,
            Photo photo,
            Status status,
            Map<String, Skill> skillList,
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
        this.description = description;
        this.photo = photo;
        this.status = status;
        this.skillList = skillList;
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
        this.description = null;
        this.photo = null;
        this.status = null;
        this.skillList = new HashMap<>();
        this.locationList = new HashMap<>();
        this.contactList = new HashMap<>();
        this.roleList = new HashMap<>();
    }

    public static UserProfile fromPrimitives(UserProfileDTO userProfile) {
        HashMap<String, Location> locationList = new HashMap<>();
        HashMap<String, Contact> contactList = new HashMap<>();
        HashMap<String, Role> roleList = new HashMap<>();
        HashMap<String, Skill> skillList = new HashMap<>();

        userProfile.getLocationList().forEach((key, location) -> locationList.put(key, Location.fromPrimitives(location)));
        userProfile.getContactList().forEach((value, contact) -> contactList.put(value, Contact.fromPrimitives(contact)));
        userProfile.getRoleList().forEach((key, role) -> roleList.put(key, Role.fromPrimitives(role)));
        userProfile.getSkillList().forEach((key, skill) -> skillList.put(key, Skill.fromPrimitives(skill)));

        return new UserProfile(
                new UserProfileId(userProfile.getId()),
                new UserProfileName(userProfile.getName()),
                new UserProfileNickname(userProfile.getNickname()),
                new UserProfileEmail(userProfile.getEmail()),
                new UserProfileAge(userProfile.getAge()),
                new UserProfileGender(userProfile.getGender()),
                new UserProfileDescription(userProfile.getDescription()),
                userProfile.getPhoto() == null ? null : Photo.fromPrimitives(userProfile.getPhoto()),
                Status.fromPrimitives(userProfile.getStatus()),
                skillList,
                locationList,
                contactList,
                roleList
        );
    }

    public UserProfileDTO toPrimitives() {
        HashMap<String, LocationDTO> locationList = new HashMap<>();
        HashMap<String, ContactDTO> contactList = new HashMap<>();
        HashMap<String, RoleDTO> roleList = new HashMap<>();
        HashMap<String, SkillDTO> skillList = new HashMap<>();

        this.locationList.forEach((key, location) -> locationList.put(key, location.toPrimitives()));
        this.contactList.forEach((key, contact) -> contactList.put(key, contact.toPrimitive()));
        this.roleList.forEach((key, role) -> roleList.put(key, role.toPrimitives()));
        this.skillList.forEach((key, skill) -> skillList.put(key, skill.toPrimitives()));

        return new UserProfileDTO(
                this.id.value(),
                this.name.value(),
                this.nickname.value(),
                this.email.value(),
                this.age.value(),
                this.gender.value(),
                this.description.value(),
                this.photo == null ? new PhotoDTO(UUID.randomUUID().toString(), "Not file") : this.photo.toPrimitives(),
                this.status.toPrimitives(),
                skillList,
                locationList,
                contactList,
                roleList
        );
    }

    public static UserProfile create(
            UserProfileId id,
            UserProfileName name,
            UserProfileNickname nickname,
            UserProfileEmail email,
            UserProfileAge age,
            UserProfileGender gender,
            UserProfileDescription description,
            Photo photo,
            Status status
    ) {
        return new UserProfile(id, name, nickname, email, age, gender, description, photo, status, new HashMap<>(), new HashMap<>(), new HashMap<>(), new HashMap<>());
    }


    public void addContact() {

    }

    public void addLocation(Map<String, Location> locations) {
        locations.forEach((key, location) -> {
            if (locationExists(key)) {
                this.locationList.remove(key);
            } else {
                this.locationList.put(key, location);
            }
        });
    }

    public void addRole(Map<String, Role> roles) {
        roles.forEach((key, role) -> {
            if (this.roleExists(key)) throw new RoleAlreadyExistException("Role not valid");
            this.roleList.put(key, role);
        });
    }

    public void addSkills(Map<String, Skill> skills) {
        skills.forEach((key, skill) -> {
            if (skillExists(key)) {
                this.skillList.remove(key);
            } else {
                this.skillList.put(key, skill);
            }
        });
    }

    private boolean roleExists(String key) {
        return this.roleList.containsKey(key);
    }

    private boolean locationExists(String location) {
        return locationList.containsKey(location);
    }

    private boolean skillExists(String skill) {
        return this.skillList.containsKey(skill);
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

    public UserProfileDescription getDescription() {
        return description;
    }

    public Map<String, Location> getLocationList() {
        return locationList;
    }

    public Map<String, Contact> getContactList() {
        return contactList;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Map<String, Skill> getSkillList() {
        return skillList;
    }

    public Map<String, Role> getRoleList() {
        return roleList;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }


    public void setSkillList(Map<String, Skill> skillList) {
        this.skillList = skillList;
    }

    public void setContactList(Map<String, Contact> contactList) {
        this.contactList = contactList;
    }

    public void setLocationList(Map<String, Location> locationList) {
        this.locationList = locationList;
    }

    public void setRoleList(Map<String, Role> roleList) {
        this.roleList = roleList;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserProfile that = (UserProfile) o;
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

}
