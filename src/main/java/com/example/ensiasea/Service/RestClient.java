package com.example.ensiasea.Service;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestClient {
    private static final String GetALLAssets = "http://localhost:8082/api/v1/assets";

    static RestTemplate restTemplate = new RestTemplate();

    public static String callGetAllAssets() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
        ResponseEntity<String> response = restTemplate.exchange(GetALLAssets, HttpMethod.GET, entity, String.class);
        return response.getBody();
    }
}
