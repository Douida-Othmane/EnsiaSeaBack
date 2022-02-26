package com.example.ensiasea.Controller;

import com.example.ensiasea.Models.AssetP;
import com.example.ensiasea.Payload.transferOwner;
import com.example.ensiasea.Service.RestClient;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping("/assets")
    public ResponseEntity<?> createAsset(@RequestBody AssetP asset) {
        return new ResponseEntity<>(
                RestClient.callCreateAsset(asset),
                HttpStatus.OK);
    }

    @DeleteMapping("/assets/{AssetId}")
    public ResponseEntity<?> deleteAssetById(@PathVariable("AssetId") String assetId) {
        return new ResponseEntity<>(
                RestClient.callDeleteAssetById(assetId),
                HttpStatus.OK);
    }

    @PutMapping("/assets/transfer/{AssetId}")
    public ResponseEntity<?> TransferOwnerShip(@PathVariable("AssetId") String assetId,
            @RequestBody transferOwner newOwner) {
        return new ResponseEntity<>(
                RestClient.transferOwner(assetId, newOwner),
                HttpStatus.OK);
    }

    @GetMapping("/assets/owner/{owner}")
    public ResponseEntity<?> GetAllAssetsByOwner(@PathVariable("owner") String owner) {
        return new ResponseEntity<>(
                RestClient.GetAllAssetsByOwner(owner),
                HttpStatus.OK);
    }

    @GetMapping("/assets/history/{assetId}")
    public ResponseEntity<?> GetHistoryOfAnAsset(@PathVariable("assetId") String assetId) {
        return new ResponseEntity<>(
                RestClient.GetHistoryOfAsset(assetId),
                HttpStatus.OK);
    }

    @PutMapping("/assets")
    public ResponseEntity<?> updateAsset(@RequestBody AssetP asset) {
        return new ResponseEntity<>(
                RestClient.updateAsset(asset),
                HttpStatus.OK);
    }
}
