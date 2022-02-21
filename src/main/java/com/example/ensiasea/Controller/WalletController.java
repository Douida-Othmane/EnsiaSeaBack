package com.example.ensiasea.Controller;

import java.util.List;

import com.example.ensiasea.DTO.WalletDTO;
import com.example.ensiasea.Models.Wallet;
import com.example.ensiasea.Response.WalletResponse;
import com.example.ensiasea.Service.WalletService;

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
@RequestMapping("/api/v1/wallets")
public class WalletController {
    private final WalletService walletService;

    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @GetMapping()
    public ResponseEntity<WalletResponse> getAllWallets() {
        List<Wallet> wallets = walletService.findAllWallets();
        return new ResponseEntity<>(
                new WalletResponse(true, null, "Getting All Wallets successfully", wallets.size(), wallets, null),
                HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WalletResponse> getWalletByWalletId(@PathVariable("id") Long id) {
        Wallet wallet = walletService.findWalletByWalletId(id);
        return new ResponseEntity<>(
                new WalletResponse(true, null, "Getting Wallet successfully", 0, null, wallet),
                HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<WalletResponse> addWallet(@RequestBody WalletDTO wallet) {
        Wallet newWallet = walletService.addWallet(wallet);
        return new ResponseEntity<>(new WalletResponse(true, null, "Creating Wallet successfully", 0, null, newWallet),
                HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<WalletResponse> updateWallet(@RequestBody WalletDTO wallet) {
        Wallet updatedWallet = walletService.updateWallet(wallet);
        return new ResponseEntity<>(
                new WalletResponse(true, null, "Updating Wallet successfully", 0, null, updatedWallet),
                HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<WalletResponse> deleteWallet(@PathVariable("id") Long id) {
        walletService.deleteWallet(id);
        return new ResponseEntity<>(
                new WalletResponse(true, null, "Deleting Wallet successfully", 0, null, null), HttpStatus.OK);
    }
}
