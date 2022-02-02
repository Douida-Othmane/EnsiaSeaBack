package com.example.ensiasea.Controller;

import com.example.ensiasea.Entity.NFTitem;
import com.example.ensiasea.Entity.User;
import com.example.ensiasea.Repository.NFTitemRepo;
import com.example.ensiasea.Service.NFTitemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/assets")
public class NftItemController {

    private final NFTitemService nftItemService;

    public NftItemController(NFTitemService nftItemService) { this.nftItemService = nftItemService; }

    @GetMapping()
    public ResponseEntity<List<NFTitem>> getAllNftItems(){
        List<NFTitem> assets = nftItemService.findAllNftItems();
        return new ResponseEntity<>(assets, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NFTitem> getNftItemById(@PathVariable("id") Long id){
        NFTitem asset = nftItemService.findNftItemById(id);
        return new ResponseEntity<>(asset, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<NFTitem> addNftItem(@RequestBody NFTitem nftItem){
        NFTitem newAsset = nftItemService.addNftItem(nftItem);
        return new ResponseEntity<>(newAsset, HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<NFTitem> updateNftItem(@RequestBody NFTitem nftItem){
        NFTitem updatedAsset = nftItemService.updateNftItem(nftItem);
        return new ResponseEntity<>(updatedAsset, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteNftItem(@PathVariable("id") Long id){
        nftItemService.deleteNftItem(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
