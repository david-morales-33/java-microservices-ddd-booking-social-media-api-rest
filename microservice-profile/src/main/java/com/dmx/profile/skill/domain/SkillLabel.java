package com.dmx.profile.skill.domain;

import com.dmx.profile.shared.domain.StringValueObject;

public final class SkillLabel extends StringValueObject {
    public SkillLabel(String value) {
        super(value);
    }

    private SkillLabel() {
        super(null);
    }
}
