package com.example.ensiasea.Controller;

import com.example.ensiasea.DTO.NFTitemDTO;
import com.example.ensiasea.Entity.NFTitem;
import com.example.ensiasea.Response.NftItemResponse;
import com.example.ensiasea.Service.NFTitemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/assets")
public class NftItemController {

    private final NFTitemService nftItemService;

    public NftItemController(NFTitemService nftItemService) {
        this.nftItemService = nftItemService;
    }

    @GetMapping()
    public ResponseEntity<NftItemResponse> getAllNftItems() {
        List<NFTitem> assets = nftItemService.findAllNftItems();
        return new ResponseEntity<>(
                new NftItemResponse(true, null, "Getting All NftItems successfully", assets.size(), assets, null),
                HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NftItemResponse> getNftItemByNftItemId(@PathVariable("id") Long id) {
        NFTitem asset = nftItemService.findNftItemByNftItemId(id);
        return new ResponseEntity<>(
                new NftItemResponse(true, null, "Getting NftItem successfully", 0, null, asset),
                HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<NftItemResponse> addNftItem(@RequestBody NFTitemDTO nftItem) {
        NFTitem newAsset = nftItemService.addNftItem(nftItem);
        return new ResponseEntity<>(new NftItemResponse(true, null, "Creating NftItem successfully", 0, null, newAsset),
                HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<NftItemResponse> updateNftItem(@RequestBody NFTitemDTO nftItem) {
        NFTitem updatedAsset = nftItemService.updateNftItem(nftItem);
        return new ResponseEntity<>(
                new NftItemResponse(true, null, "Updating NftItem successfully", 0, null, updatedAsset),
                HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<NftItemResponse> deleteNftItem(@PathVariable("id") Long id) {
        nftItemService.deleteNftItem(id);
        return new ResponseEntity<>(
                new NftItemResponse(true, null, "Updating NftItem successfully", 0, null, null), HttpStatus.OK);
    }
}
