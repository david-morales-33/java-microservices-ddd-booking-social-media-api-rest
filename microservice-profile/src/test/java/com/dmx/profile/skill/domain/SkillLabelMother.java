package com.dmx.profile.skill.domain;

import com.dmx.profile.shared.domain.WordMother;

public final class SkillLabelMother {
    public static SkillLabel create(String value) {
        return new SkillLabel(value);
    }

    public static SkillLabel random() {
        return new SkillLabel(WordMother.random());
    }
}
