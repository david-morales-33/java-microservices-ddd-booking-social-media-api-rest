package com.dmx.profile.user_profile.domain;

import com.dmx.profile.status.domain.Status;
import com.dmx.profile.status.domain.StatusDTO;

import java.util.UUID;

public class Test {
    public static void main(String[] args) {
        UserProfileDTO user = UserProfileDTO.builder().id("bsajahs").age(24).email("David@").build();
        System.out.println(user.toString());
    }
}
