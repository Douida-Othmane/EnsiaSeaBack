package com.example.ensiasea.Controller;

import com.example.ensiasea.DTO.PriceHistoryDTO;
import com.example.ensiasea.Entity.PriceHistory;
import com.example.ensiasea.Response.PriceHistoryResponse;
import com.example.ensiasea.Service.PriceHistoryService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1/priceHistories")
public class PriceHistoryController {
    private final PriceHistoryService priceHistoryService;

    public PriceHistoryController(PriceHistoryService priceHistoryService) {
        this.priceHistoryService = priceHistoryService;
    }
    
    @GetMapping
    public ResponseEntity<PriceHistoryResponse> getAllPriceHistory(){
        List<PriceHistory> priceHistories = priceHistoryService.findAllPriceHistory();
        return new ResponseEntity<>(
            new PriceHistoryResponse(true, null, "Getting all Price Histories successfully", priceHistories.size(), priceHistories, null)
            ,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PriceHistoryResponse> getPriceHistoryByID(@PathVariable("id") Long id){
        PriceHistory priceHistory = priceHistoryService.findPriceHistoryById(id);
        return new ResponseEntity<>(
            new PriceHistoryResponse(true, null, "Price History found", 0, null, priceHistory)
            , HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PriceHistoryResponse> addPriceHistory(@RequestBody PriceHistoryDTO priceHistoryDTO){
        PriceHistory newPriceHistory = priceHistoryService.addPriceHistory(priceHistoryDTO);
        return new ResponseEntity<>(
            new PriceHistoryResponse(true, null, "Price History added successfully", 0, null, newPriceHistory)
            , HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<PriceHistoryResponse> updatePriceHistory(@RequestBody PriceHistoryDTO priceHistoryDTO){
        PriceHistory updatedPriceHistory = priceHistoryService.updatePriceHistory(priceHistoryDTO);
        return new ResponseEntity<>(
            new PriceHistoryResponse(true, null, "Price History updated successfully", 0, null, updatedPriceHistory)
            , HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PriceHistoryResponse> deletePriceHistory(@PathVariable("id") Long id){
        priceHistoryService.deletePriceHistory(id);
        return new ResponseEntity<>(
            new PriceHistoryResponse(true, null, "Price History deleted successfully", 0, null, null)
            , HttpStatus.OK);
    }

}
