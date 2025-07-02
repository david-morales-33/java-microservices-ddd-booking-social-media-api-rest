package com.dmx.profile.user_profile.application.create_user_profile;

import com.dmx.profile.description.domain.DescriptionDTO;
import com.dmx.profile.shared.domain.bus.command.Command;
import com.dmx.profile.status.domain.StatusDTO;

public final class CreateUserProfileCommand implements Command {
    private final String  id;
    private final String  name;
    private final String  nickname;
    private final String  email;
    private final Integer  age;
    private final String  gender;
    private final StatusDTO status;
    private final DescriptionDTO description;

    public CreateUserProfileCommand(String id, String name, String nickname, String email, Integer age, String gender, StatusDTO status, DescriptionDTO description) {
        this.id = id;
        this.name = name;
        this.nickname = nickname;
        this.email = email;
        this.age = age;
        this.gender = gender;
        this.status = status;
        this.description = description;
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
}
