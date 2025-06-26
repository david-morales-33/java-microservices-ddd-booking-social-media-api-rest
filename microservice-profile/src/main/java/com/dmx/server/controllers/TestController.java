package com.dmx.server.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/profile")
public class TestController {
    @GetMapping("/ping")
    @ResponseStatus(HttpStatus.OK)
    public void test(){
        System.out.println("Pong.....");
    }
}
