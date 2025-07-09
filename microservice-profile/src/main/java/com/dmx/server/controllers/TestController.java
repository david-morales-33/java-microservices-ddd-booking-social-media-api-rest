package com.dmx.server.controllers;

import com.dmx.profile.shared.domain.DomainError;
import com.dmx.profile.shared.domain.bus.command.CommandBus;
import com.dmx.profile.shared.domain.bus.query.Query;
import com.dmx.profile.shared.domain.bus.query.QueryBus;
import com.dmx.profile.shared.infrastructure.spring.ApiController;
import com.dmx.profile.user_profile.application.find.FindUserProfileQuery;
import com.dmx.profile.user_profile.application.find.UserProfileResponse;
import com.dmx.profile.user_profile.domain.UserProfile;
import com.dmx.profile.user_profile.domain.UserProfileDTO;
import com.dmx.profile.user_profile.domain.UserProfileId;
import com.dmx.profile.user_profile.domain.UserProfileRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Optional;

@RestController
@RequestMapping("/api/profile")
public class TestController extends ApiController {

    public TestController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @GetMapping("/ping")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UserProfileDTO> test(){
        //Optional<UserProfile> response = this.repo.find(new UserProfileId("3b8958af-7ce6-4364-9ef4-243689c780ed"));

        Query query = new FindUserProfileQuery("3b8958af-7ce6-4364-9ef4-243689c780ed");

        UserProfileResponse response = this.ask(query);

        //response.ifPresent(profile -> System.out.println(profile.toPrimitives()));

        System.out.println("Pong.....");
        return ResponseEntity
                .ok()
                .body(response.response());
    }

    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
        return null;
    }
}
