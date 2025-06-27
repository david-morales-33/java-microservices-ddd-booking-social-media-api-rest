package com.dmx.profile.description.domain;

import com.dmx.profile.skill.domain.SkillDTO;

import java.util.HashMap;

public record DescriptionDTO(String id, String content, HashMap<String, SkillDTO> skillList) {
}
