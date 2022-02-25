package com.example.ensiasea.Controller;

import com.example.ensiasea.Service.RestClient;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/blockchain")
public class blockchainController {

    @GetMapping("/assets")
    public ResponseEntity<?> getAllAssetsFromBlockChain() {
        return new ResponseEntity<>(
                RestClient.callGetAllAssets(),
                HttpStatus.OK);
    }
}
