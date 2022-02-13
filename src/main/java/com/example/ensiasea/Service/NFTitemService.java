package com.example.ensiasea.Service;

import com.example.ensiasea.DTO.NFTitemDTO;
import com.example.ensiasea.Entity.NFTitem;
import com.example.ensiasea.Exception.ApiRequestException;
import com.example.ensiasea.Exception.NftItemNotFoundException;
import com.example.ensiasea.Repository.NFTitemRepo;
import com.example.ensiasea.Repository.UserRepo;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class NFTitemService {
    private final NFTitemRepo nftItemRepo;
    private final UserService userService;

    @Autowired
    public NFTitemService(NFTitemRepo nftItemRepo, UserService userService) {
        this.nftItemRepo = nftItemRepo;
        this.userService = userService;
    }

    public NFTitem addNftItem(NFTitemDTO nftItemDTO) {
        try {
            NFTitem nftItem = new NFTitem();
            BeanUtils.copyProperties(nftItemDTO, nftItem, "nftItemId", "nftItemOwnerId");
            nftItem.setNftItemOwnerId(userService.findUserById(nftItemDTO.getNftItemOwnerId()));
            return nftItemRepo.save(nftItem);
        } catch (Exception exception) {

            throw new ApiRequestException("Error While Creating NftItem", exception.getMessage());
        }
    }

    public List<NFTitem> findAllNftItems() {
        try {
            return nftItemRepo.findAll();

        } catch (Exception exception) {
            throw new ApiRequestException("Error While Getting All NftItems", exception.getMessage());
        }
    }

    public NFTitem updateNftItem(NFTitemDTO nftItemDTO) {
        try {
            NFTitem nftItem = nftItemRepo.findNftItemByNftItemId(nftItemDTO.getNftItemId()).get();
            BeanUtils.copyProperties(nftItemDTO, nftItem, "nftItemId", "nftItemOwnerId", "nftItemPicture",
                    "creationDate");
            nftItem.setNftItemOwnerId(userService.findUserById(nftItemDTO.getNftItemOwnerId()));
            return nftItemRepo.save(nftItem);
        } catch (Exception exception) {
            throw new ApiRequestException("Error While Updating NftItem", exception.getMessage());
        }

    }

    public NFTitem findNftItemByNftItemId(Long id) {

        return nftItemRepo.findNftItemByNftItemId(id)
                .orElseThrow(() -> new ApiRequestException("NftItem Not Found"));
    }

    public void deleteNftItem(Long id) {
        try {
            nftItemRepo.deleteById(id);

        } catch (Exception exception) {
            throw new ApiRequestException("Error While Deleting NftItem", exception.getMessage());
        }
    }
}
