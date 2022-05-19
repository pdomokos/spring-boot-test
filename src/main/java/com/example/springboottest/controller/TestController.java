package com.example.springboottest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

@RequiredArgsConstructor
@RestController
public class TestController {

    private final WebClient webClient;

    @Value("${test.host}")
    private String testHost;

    @GetMapping(value = "/webflux-webclient-test")
    public Mono<String> getTestUsingWebfluxWebclient(@RequestParam long delay) {
        return webClient.get().uri("/v1/get-test-string-1?delay={delay}", delay)
                .retrieve()
                .bodyToMono(String.class);
    }
}
