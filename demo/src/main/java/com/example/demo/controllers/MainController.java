package com.example.demo.controllers;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class MainController {
    
    private static final String SOUNDCLOUD_API_URL = "https://api.soundcloud.com/tracks?client_id=YOUR_SOUNDCLOUD_CLIENT_ID";

    @GetMapping("/me/tracks")
    public String getSongs(@RequestHeader("Authorization") String authorization) {
        String token = authorization.split(" ")[1];
        System.out.println("Token: " + token);

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + token);
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

        ResponseEntity<String> response = restTemplate.exchange("https://api.spotify.com/v1/me/tracks", HttpMethod.GET, entity, String.class);
        return response.getBody();
    }
}
