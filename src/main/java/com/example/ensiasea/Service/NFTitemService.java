package com.example.ensiasea.Service;


import com.example.ensiasea.Entity.NFTitem;
import com.example.ensiasea.Exception.NftItemNotFoundException;
import com.example.ensiasea.Repository.NFTitemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NFTitemService {
    private final NFTitemRepo nftitemRepo;

    @Autowired
    public NFTitemService(NFTitemRepo nftitemRepo) {
        this.nftitemRepo = nftitemRepo;
    }

    public NFTitem addNftItem(NFTitem nftItem){
        return nftitemRepo.save(nftItem);
    }

    public List<NFTitem> findAllNftItems(){
        return nftitemRepo.findAll();
    }

    public NFTitem updateNftItem(NFTitem nftItem){
        return nftitemRepo.save(nftItem);
    }

    public NFTitem findNftItemById(Long id){
        return nftitemRepo.findNftItemById(id)
                .orElseThrow(() -> new NftItemNotFoundException("Nft item by id "+id+" was not found"));
    }

    public void deleteNftItem(Long id){
        nftitemRepo.deleteNftItemById(id);
    }
}
