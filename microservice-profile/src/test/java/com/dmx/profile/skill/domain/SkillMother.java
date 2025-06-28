package com.dmx.profile.skill.domain;

public final class SkillMother {
    public static Skill create(SkillId id, SkillLabel label) {
        return new Skill(id, label);
    }

    public static Skill random() {
        return new Skill(SkillIdMother.ranndom(), SkillLabelMother.random());
    }
}
