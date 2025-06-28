package com.dmx.profile.skill.domain;

import com.dmx.profile.shared.domain.UuidMother;

public final class SkillIdMother {
    public static SkillId create(String value){
        return new SkillId(value);
    }

    public static SkillId ranndom(){
        return new SkillId(UuidMother.random());
    }
}
