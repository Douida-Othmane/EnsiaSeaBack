package com.example.ensiasea.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.example.ensiasea.DTO.WalletDTO;
import com.example.ensiasea.Entity.Wallet;
import com.example.ensiasea.Exception.ApiRequestException;
import com.example.ensiasea.Repository.WalletRepo;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class WalletService {

    private final WalletRepo walletRepo;
    private final UserService userService;

    @Autowired
    public WalletService(WalletRepo walletRepo, UserService userService) {
        this.walletRepo = walletRepo;
        this.userService = userService;
    }

    public List<Wallet> findAllWallets() {
        try {
            return walletRepo.findAll();

        } catch (Exception exception) {
            throw new ApiRequestException("Error While Getting All Wallets", exception.getMessage());
        }
    }

    public Wallet findWalletByWalletId(Long id) {

        return walletRepo.findWalletByWalletId(id).orElseThrow(() -> new ApiRequestException("Wallet Not Found"));
    }

    public Wallet addWallet(WalletDTO walletDTO) {
        try {
            Wallet wallet = new Wallet();
            BeanUtils.copyProperties(walletDTO, wallet, "ownerId");
            wallet.setOwnerId(userService.findUserById(walletDTO.getOwnerId()));
            return walletRepo.save(wallet);
        } catch (Exception exception) {

            throw new ApiRequestException("Error While Creating Wallet", exception.getMessage());
        }
    }

    public Wallet updateWallet(WalletDTO walletDTO) {
        try {
            Wallet wallet = walletRepo.findWalletByWalletId(walletDTO.getWalletId()).get();
            BeanUtils.copyProperties(walletDTO, wallet, "walletId", "ownerId");
            wallet.setOwnerId(userService.findUserById(walletDTO.getOwnerId()));
            return walletRepo.save(wallet);
        } catch (Exception exception) {
            throw new ApiRequestException("Error While Updating Wallet", exception.getMessage());
        }

    }

    public void deleteWallet(Long id) {
        try {
            walletRepo.deleteById(id);

        } catch (Exception exception) {
            throw new ApiRequestException("Error While Deleting Wallet", exception.getMessage());
        }
    }

}
