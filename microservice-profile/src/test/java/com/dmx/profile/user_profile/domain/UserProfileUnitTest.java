package com.dmx.profile.user_profile.domain;

import com.dmx.profile.location.domain.Location;
import com.dmx.profile.location.domain.LocationMother;
import com.dmx.profile.role.domain.Role;
import com.dmx.profile.role.domain.RoleTest;
import com.dmx.profile.skill.domain.Skill;
import com.dmx.profile.skill.domain.SkillMother;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;


public final class UserProfileUnitTest {

    @Test
    void it_sould_add_a_new_user_locations() {
        UserProfile profile = UserProfileMother.random();
        HashMap<String, Location> locationList = new HashMap<>();

        Location location1 = LocationMother.random();
        Location location2 = LocationMother.random();

        locationList.put(location1.getId().value(), location1);
        locationList.put(location2.getId().value(), location2);

        profile.addLocation(locationList);

        assertEquals(location1, profile.getLocationList().get(location1.getId().value()));
        assertEquals(location2, profile.getLocationList().get(location2.getId().value()));
    }

    @Test
    void it_should_remove_a_existenting_location() {
        //GIVEN
        UserProfile profile = UserProfileMother.random();
        HashMap<String, Location> locationList1 = new HashMap<>();
        HashMap<String, Location> locationList2 = new HashMap<>();

        Location location1 = LocationMother.random();
        Location location2 = LocationMother.random();

        locationList1.put(location1.getId().value(), location1);
        locationList1.put(location2.getId().value(), location2);

        locationList2.put(location1.getId().value(), location1);

        //WHEN
        profile.addLocation(locationList1);
        profile.addLocation(locationList2);

        //THEN
        assertNull(profile.getLocationList().get(location1.getId().value()));
        assertEquals(location2, profile.getLocationList().get(location2.getId().value()));
    }

    @Test
    void it_should_add_a_new_skills() {

        //GIVEN
        UserProfile userProfile = UserProfileMother.random();
        HashMap<String, Skill> skillList = new HashMap<>();

        Skill skill1 = SkillMother.random();
        Skill skill2 = SkillMother.random();

        skillList.put(skill1.getId().value(), skill1);
        skillList.put(skill2.getId().value(), skill2);

        //WHEN
        userProfile.addSkills(skillList);

        //THEN
        assertEquals(skill1, userProfile.getDescription().getSkillList().get(skill1.getId().value()));
        assertEquals(skill2, userProfile.getDescription().getSkillList().get(skill2.getId().value()));
    }

    @Test
    void it_should_remove_a_existenting_skills() {

        //GIVEN
        UserProfile userProfile = UserProfileMother.random();
        HashMap<String, Skill> skillList1 = new HashMap<>();
        HashMap<String, Skill> skillList2 = new HashMap<>();

        Skill skill1 = SkillMother.random();
        Skill skill2 = SkillMother.random();

        skillList1.put(skill1.getId().value(), skill1);
        skillList1.put(skill2.getId().value(), skill2);

        skillList2.put(skill1.getId().value(), skill1);

        //WHEN
        userProfile.addSkills(skillList1);
        userProfile.addSkills(skillList2);

        //THEN
        assertNull(userProfile.getDescription().getSkillList().get(skill1.getId().value()));
        assertEquals(skill2, userProfile.getDescription().getSkillList().get(skill2.getId().value()));

    }

    @Test
    void it_should_add_a_new_role() {

        //GIVE
        UserProfile userProfile = UserProfileMother.random();
        HashMap<String, Role> roleList = new HashMap<>();

        Role role1 = RoleTest.random();
        Role role2 = RoleTest.random();

        roleList.put(role1.getId().value(), role1);
        roleList.put(role2.getId().value(), role2);

        //WHEN
        userProfile.addRole(roleList);

        //THEN
        assertEquals(role1, userProfile.getRoleList().get(role1.getId().value()));
        assertEquals(role2, userProfile.getRoleList().get(role2.getId().value()));
    }

    @Test
    void it_should_throw_an_exception_when_role_already_exists() {

        //GIVE
        UserProfile userProfile = UserProfileMother.random();
        HashMap<String, Role> roleList1 = new HashMap<>();
        HashMap<String, Role> roleList2 = new HashMap<>();

        Role role1 = RoleTest.random();

        roleList1.put(role1.getId().value(), role1);
        roleList2.put(role1.getId().value(), role1);

        //WHEN
        userProfile.addRole(roleList1);

        //THEN
        assertThrows(RoleAlreadyExistException.class, () -> userProfile.addRole(roleList2));
    }
}
