package com.dmx.profile.description.domain;

import com.dmx.profile.skill.domain.Skill;
import com.dmx.profile.skill.domain.SkillMother;

import java.util.HashMap;

public final class DescriptionMother {
    public static Description create(DescriptionId id, DescriptionContent content, HashMap<String, Skill> skillList) {
        return new Description(id, content, skillList);
    }

    public static Description random() {
        HashMap<String, Skill> skillList = new HashMap<>();
        for (int i = 0; i < 3; i++) {
            Skill skill = SkillMother.random();
            skillList.put(skill.getId().value(), skill);
        }
        return new Description(
                DescriptionIdMother.random(),
                DescriptionContentMother.random(),
                skillList
        );
    }
}
