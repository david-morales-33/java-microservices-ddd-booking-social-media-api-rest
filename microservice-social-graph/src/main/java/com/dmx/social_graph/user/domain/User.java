package com.dmx.social_graph.user.domain;

import java.util.Objects;

public final class User {
    private final UserId id;
    private final UserName name;
    private final UserNickname nickname;
    private final UserPhoto photo;

    public User(UserId id, UserName name, UserNickname nickname, UserPhoto photo) {
        this.id = id;
        this.name = name;
        this.nickname = nickname;
        this.photo = photo;
    }

    public UserId getId() {
        return id;
    }

    public UserName getName() {
        return name;
    }

    public UserNickname getNickname() {
        return nickname;
    }

    public UserPhoto getPhoto() {
        return photo;
    }

    public static User fromPrimitives(UserDTO userDTO) {
        return new User(
                new UserId(userDTO.id()),
                new UserName(userDTO.name()),
                new UserNickname(userDTO.nickname()),
                new UserPhoto(userDTO.photo())
        );
    }

    public UserDTO toPrimitives() {
        return new UserDTO(
                id.value(),
                name.value(),
                nickname.value(),
                photo.value()
        );
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User that = (User) o;
        return id.equals(that.id) &&
                name.equals(that.name) &&
                nickname.equals(that.nickname) &&
                photo.equals(that.photo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, nickname, photo);
    }
}
