package com.example.ensiasea.Controller;

import com.example.ensiasea.DTO.NFTitemDTO;
import com.example.ensiasea.Models.NFTitem;
import com.example.ensiasea.Response.NftItemResponse;
import com.example.ensiasea.Service.NFTitemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import io.jsonwebtoken.io.IOException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/assets")
public class NftItemController {

    private final NFTitemService nftItemService;

    public NftItemController(NFTitemService nftItemService) {
        this.nftItemService = nftItemService;
    }

    @PostMapping("/upload")
    public ResponseEntity<Object> fileUpload(@RequestParam("File") MultipartFile file)
            throws IOException, java.io.IOException {
        nftItemService.uploadAssets(file);
        return new ResponseEntity<Object>("The File Uploaded Successfully", HttpStatus.OK);
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

    @PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<NftItemResponse> addNftItem(@RequestPart("nftItemPicture") MultipartFile picture,
            @RequestPart NFTitemDTO nftItem) throws java.io.IOException {
        nftItem.setNftItemPicture(picture);
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
                new NftItemResponse(true, null, "Deleting NftItem successfully", 0, null, null), HttpStatus.OK);
    }

}
