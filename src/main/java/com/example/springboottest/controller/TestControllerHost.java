package com.example.springboottest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestControllerHost {

    @GetMapping("/v1/get-test-string")
    public String getTest() {
        return "test string 1";
    }

    @GetMapping("/v1/get-test-string-async")
    public String getTestAsync() {
        return "test string 3";
    }
}
