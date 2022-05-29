package com.example.webfluxtest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
public class TestController {

    private final WebClient webClient;

    @Value("${test.host}")
    private String testHost;

    @GetMapping(value = "/webflux-webclient-test")
    public Mono<String> getTestUsingWebfluxWebclient(@RequestParam long delay) {
        return webClient.get().uri("/v1/get-test-string?delay={delay}", delay)
                .retrieve()
                .bodyToMono(String.class);
    }
}
