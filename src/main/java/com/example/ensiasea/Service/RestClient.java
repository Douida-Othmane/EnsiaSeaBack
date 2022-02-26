package com.example.ensiasea.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.example.ensiasea.DTO.Blockchain.ResultHistory;
import com.example.ensiasea.DTO.Blockchain.Results;
import com.example.ensiasea.DTO.Blockchain.ResultsP;
import com.example.ensiasea.Models.Asset;
import com.example.ensiasea.Models.AssetP;
import com.example.ensiasea.Payload.transferOwner;
import com.google.gson.Gson;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestClient {
    private static final String assetsEndpoint = "http://localhost:5000/api/v1/assets/";

    static RestTemplate restTemplate = new RestTemplate();

    public static Results callGetAllAssets() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
        ResponseEntity<String> response = restTemplate.exchange(assetsEndpoint, HttpMethod.GET, entity, String.class);
        Gson g = new Gson();
        Results results = g.fromJson(response.getBody(), Results.class);
        return results;
    }

    public static ResultsP callCreateAsset(AssetP asset) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<AssetP> entity = new HttpEntity<AssetP>(asset, headers);
        ResponseEntity<String> response = restTemplate.exchange(assetsEndpoint, HttpMethod.POST, entity, String.class);
        Gson g = new Gson();
        ResultsP results = g.fromJson(response.getBody(), ResultsP.class);
        return results;
    }

    public static ResultsP callDeleteAssetById(String assetId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        Map<String, String> params = new HashMap<>();
        params.put("assetId", assetId);
        ResponseEntity<String> response = restTemplate.exchange(assetsEndpoint + "{assetId}",
                HttpMethod.DELETE, null,
                String.class, assetId);
        Gson g = new Gson();
        ResultsP results = g.fromJson(response.getBody(), ResultsP.class);
        return results;
    }

    public static ResultsP transferOwner(String assetId, transferOwner newOwner) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        Map<String, String> params = new HashMap<>();
        params.put("assetId", assetId);
        HttpEntity<transferOwner> entity = new HttpEntity<transferOwner>(newOwner, headers);

        ResponseEntity<String> response = restTemplate.exchange(assetsEndpoint + "/transfert/{assetId}",
                HttpMethod.PUT, entity,
                String.class, assetId);
        Gson g = new Gson();
        ResultsP results = g.fromJson(response.getBody(), ResultsP.class);
        return results;
    }

    public static Results GetAllAssetsByOwner(String owner) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        Map<String, String> params = new HashMap<>();
        params.put("owner", owner);

        ResponseEntity<String> response = restTemplate.exchange(assetsEndpoint + "/owner/{owner}",
                HttpMethod.GET, null,
                String.class, owner);
        Gson g = new Gson();
        Results results = g.fromJson(response.getBody(), Results.class);
        return results;
    }

    public static ResultsP updateAsset(AssetP asset) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<AssetP> entity = new HttpEntity<AssetP>(asset, headers);
        ResponseEntity<String> response = restTemplate.exchange(assetsEndpoint,
                HttpMethod.PUT, entity,
                String.class);
        Gson g = new Gson();
        ResultsP results = g.fromJson(response.getBody(), ResultsP.class);
        return results;
    }

    public static ResultHistory GetHistoryOfAsset(String assetId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        ResponseEntity<String> response = restTemplate.exchange(assetsEndpoint + "history/{assetId}",
                HttpMethod.GET, null,
                String.class, assetId);
        Gson g = new Gson();
        ResultHistory results = g.fromJson(response.getBody(), ResultHistory.class);
        return results;
    }
}
