package com.dmx.profile.description.domain;

import com.dmx.profile.skill.domain.Skill;
import com.dmx.profile.skill.domain.SkillDTO;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class Description {
    private final DescriptionId id;
    private final DescriptionContent content;
    private Map<String, Skill> skillList;

    public Description(DescriptionId id, DescriptionContent content, Map<String, Skill> skillList) {
        this.id = id;
        this.content = content;
        this.skillList = skillList;
    }

    public Description() {
        this.id = null;
        this.content = null;
        this.skillList = new HashMap<>();
    }

    public static Description create(DescriptionId id, DescriptionContent content, Map<String, Skill> skillList) {
        return new Description(id, content, skillList);
    }

    public static Description fromPrimitives(DescriptionDTO description) {
        HashMap<String, Skill> skillList = new HashMap<>();

        description.skillList().forEach((id, skill) -> {
            skillList.put(id, Skill.fromPrimitives(skill));
        });

        return new Description(
                new DescriptionId(description.id()),
                new DescriptionContent(description.content()),
                skillList
        );
    }

    public DescriptionDTO toPrimitives() {

        HashMap<String, SkillDTO> skillList = new HashMap<>();

        this.skillList.forEach((id, skill) -> {
            skillList.put(id, skill.toPrimitives());
        });

        return new DescriptionDTO(
                this.id.value(),
                this.content.value(),
                skillList
        );
    }

    public void addSkill(Skill skill) {

        assert skill.getId() != null;
        this.skillList.put(skill.getId().value(), skill);
    }

    public void removeSkill(String key) {
        this.skillList.remove(key);
    }

    public DescriptionId getId() {
        return id;
    }

    public DescriptionContent getContent() {
        return content;
    }

    public Map<String, Skill> getSkillList() {
        return skillList;
    }

    public void setSkillList(Map<String, Skill> skillList) {
        this.skillList = skillList;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Description that = (Description) o;
        return Objects.equals(id, that.id) && Objects.equals(content, that.content) && Objects.equals(skillList, that.skillList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content, skillList);
    }

    @Override
    public String toString() {
        return "Description{" +
                "id=" + id +
                ", content=" + content +
                ", skillList=" + skillList +
                '}';
    }
}
