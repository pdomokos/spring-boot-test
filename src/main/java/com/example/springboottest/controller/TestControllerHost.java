package com.example.springboottest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
public class TestControllerHost {

    @GetMapping("/v1/get-test-string-1")
    public Mono<String> getTest1(@RequestParam long delay) {
        return Mono.just("test string 1").delayElement(Duration.ofMillis(delay));
    }
}
