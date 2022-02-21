package com.example.ensiasea.Service;

import com.example.ensiasea.DTO.PriceHistoryDTO;
import com.example.ensiasea.Repository.PriceHistoryRepo;
import com.example.ensiasea.Exception.ApiRequestException;
import com.example.ensiasea.Models.PriceHistory;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.transaction.Transactional;

@Service
@Transactional
public class PriceHistoryService {
    private final PriceHistoryRepo priceHistoryRepo;
    private final NFTitemService nfTitemService;

    @Autowired
    public PriceHistoryService(PriceHistoryRepo priceHistoryRepo, NFTitemService nfTitemService) {
        this.priceHistoryRepo = priceHistoryRepo;
        this.nfTitemService = nfTitemService;
    }

    public List<PriceHistory> findAllPriceHistory() {
        try {
            return priceHistoryRepo.findAll();
        } catch (Exception exception) {
            throw new ApiRequestException("Error While Getting All Price histories", exception.getMessage());
        }
    }

    public PriceHistory findPriceHistoryById(Long id) {
        return priceHistoryRepo.findPriceHistoryByPriceHistoryID(id)
                .orElseThrow(() -> new ApiRequestException("Price history by Id " + id + " not found !"));
    }

    public PriceHistory addPriceHistory(PriceHistoryDTO priceHistoryDTO) {
        try {
            PriceHistory priceHistory = new PriceHistory();
            BeanUtils.copyProperties(priceHistoryDTO, priceHistory, "previousOwner", "previousOwner", "nftItemId");
            priceHistory.setNftItem(nfTitemService.findNftItemByNftItemId(priceHistoryDTO.getNftItemID()));
            priceHistory.setPreviousOwner(nfTitemService.findNftItemByNftItemId(priceHistoryDTO.getNftItemID())
                    .getNftItemOwnerId().getUsername());
            return priceHistoryRepo.save(priceHistory);
        } catch (Exception exception) {
            throw new ApiRequestException("Error while adding new Price History", exception.getMessage());
        }

    }

    public PriceHistory updatePriceHistory(PriceHistoryDTO priceHistoryDTO) {
        try {
            PriceHistory newPriceHistory = priceHistoryRepo
                    .findPriceHistoryByPriceHistoryID(priceHistoryDTO.getPriceHistoryID()).get();
            BeanUtils.copyProperties(priceHistoryDTO, newPriceHistory, "priceHistoryID", "nftItemID");
            newPriceHistory.setNftItem(nfTitemService.findNftItemByNftItemId(priceHistoryDTO.getNftItemID()));
            return priceHistoryRepo.save(newPriceHistory);
        } catch (Exception exception) {
            throw new ApiRequestException("Error while updating Price History", exception.getMessage());
        }

    }

    public void deletePriceHistory(Long id) {
        try {
            priceHistoryRepo.deleteById(id);
        } catch (Exception exception) {
            throw new ApiRequestException("Error while deleting Price History", exception.getMessage());
        }
    }

}
