package com.example.ensiasea.Service;

import com.example.ensiasea.DTO.NFTitemDTO;
import com.example.ensiasea.Exception.ApiRequestException;
import com.example.ensiasea.Models.AssetP;
import com.example.ensiasea.Models.NFTitem;
import com.example.ensiasea.Models.User;
import com.example.ensiasea.Payload.transferOwner;
import com.example.ensiasea.Repository.NFTitemRepo;
import com.example.ensiasea.Repository.UserRepo;
import com.example.ensiasea.Utils.CheckSum;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class NFTitemService {
    private final NFTitemRepo nftItemRepo;
    private final UserService userService;
    private final UserRepo userRepo;

    @Autowired
    public NFTitemService(NFTitemRepo nftItemRepo, UserService userService, UserRepo userRepo) {
        this.nftItemRepo = nftItemRepo;
        this.userService = userService;
        this.userRepo = userRepo;
    }

    public NFTitem addNftItem(NFTitemDTO nftItemDTO) throws IOException {
        try {
            String ext = nftItemDTO.getNftItemPicture().getOriginalFilename().split("\\.")[1];
            NFTitem nftItem = new NFTitem();
            BeanUtils.copyProperties(nftItemDTO, nftItem, "nftItemId", "nftItemOwnerId", "nftItemPicture");
            nftItem.setNftItemOwnerId(userService.findUserById(nftItemDTO.getNftItemOwnerId()));
            Date date = new Date();
            String nameFile = nftItemDTO.getNftItemName().toString()
                    + date.toString().replace(' ', '_').replace(':', '-') + "." + ext;
            File myFile = new File(
                    System.getProperty("user.dir") + "/assets/" +
                            nameFile);
            myFile.createNewFile();
            FileOutputStream fos = new FileOutputStream(myFile);
            fos.write(nftItemDTO.getNftItemPicture().getBytes());
            fos.close();
            String checksum = CheckSum.getFileChecksum(myFile);
            // Path
            nftItem.setNftItemPicture(System.getProperty("user.dir") + "/assets/" +
                    nameFile);
            // * Create Asset in t he blockchain
            RestClient.callCreateAsset(new AssetP(nameFile.substring(0, nameFile.length() - 4), "Image",
                    nftItem.getNftItemOwnerId().getUsername(),
                    checksum, nftItem.getNftItemPrice()));
            return nftItemRepo.save(nftItem);

        } catch (Exception exception) {

            throw new ApiRequestException("Error While Creating NftItem", exception.getMessage());
        }

    }

    public NFTitem transferOwnerShip(Long assetId, transferOwner transferowner) {
        NFTitem asset = this.findNftItemByNftItemId(assetId);
        System.out.println(asset.getNftItemName());
        User newOwner = userRepo.findByUsername(transferowner.getNewOwner());
        if (newOwner == null) {
            throw new ApiRequestException("Can't Transfer to a user that doesn't exist");
        }
        asset.setNftItemOwnerId(newOwner);
        System.out.println(asset.getNftItemPicture().split("/")[6]);
        RestClient.transferOwner(asset.getNftItemPicture().split("/")[6].substring(0,
                asset.getNftItemPicture().split("/")[6].length() - 4), transferowner);
        return asset;
    }

    public List<NFTitem> findAllNftItems() {
        try {
            return nftItemRepo.findAll();

        } catch (Exception exception) {
            throw new ApiRequestException("Error While Getting All NftItems", exception.getMessage());
        }
    }

    public void uploadAssets(MultipartFile file) throws IOException {
        File myFile = new File(
                System.getProperty("user.dir") + "/src/main/resources/assets/" + file.getOriginalFilename());
        myFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(myFile);
        fos.write(file.getBytes());
        fos.close();
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
            String assetId = this.findNftItemByNftItemId(id).getNftItemPicture().split("/")[6].substring(0,
                    this.findNftItemByNftItemId(id).getNftItemPicture().split("/")[6].length() - 4);
            nftItemRepo.deleteById(id);
            RestClient.callDeleteAssetById(assetId);
        } catch (Exception exception) {
            throw new ApiRequestException("Error While Deleting NftItem", exception.getMessage());
        }
    }
}
