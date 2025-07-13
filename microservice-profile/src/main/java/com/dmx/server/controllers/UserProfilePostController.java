package com.dmx.server.controllers;

import com.dmx.profile.photo.domain.PhotoDTO;
import com.dmx.profile.shared.domain.DomainError;
import com.dmx.profile.shared.domain.bus.command.Command;
import com.dmx.profile.shared.domain.bus.command.CommandBus;
import com.dmx.profile.shared.domain.bus.query.QueryBus;
import com.dmx.profile.shared.infrastructure.spring.ApiController;
import com.dmx.profile.status.domain.StatusDTO;
import com.dmx.profile.user_profile.application.create_user_profile.CreateUserProfileCommand;
import com.dmx.profile.user_profile.domain.UserProfileAlreadyExistsException;
import com.dmx.server.dto.CreateUserProfileRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/api/msvc-profile")
public class UserProfilePostController extends ApiController {
    public UserProfilePostController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @PostMapping(value = "/user")
    public ResponseEntity<String> index(@RequestBody CreateUserProfileRequest request){

        Command newUser = new CreateUserProfileCommand(
                request.id(),
                request.name(),
                request.nickname(),
                request.email(),
                request.age(),
                request.gender(),
                request.description(),
                new PhotoDTO("", ""),
                new StatusDTO("", "")
        );
        dispatch(newUser);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
        return new HashMap<Class<? extends DomainError>, HttpStatus>(){
                {
                    put(UserProfileAlreadyExistsException.class, HttpStatus.BAD_REQUEST);
                }
        };
    }
}
