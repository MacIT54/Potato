package ru.cft.template.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.cft.template.dto.WalletDto;
import ru.cft.template.service.WalletService;

@RestController
@RequestMapping
public class WalletController {

    private final WalletService walletService;

    @Autowired
    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @PostMapping("wallet/add")
    public ResponseEntity<String> createWallet(@RequestBody WalletDto wallet) {
        walletService.create(wallet);
        return new ResponseEntity<>("Wallet Created Successfully", HttpStatus.CREATED);
    }

    @GetMapping("wallet/bill/{id}")
    public ResponseEntity<WalletDto> getWalletById(@PathVariable String id) {
        WalletDto wallet = walletService.findById(id);
        if (wallet == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(wallet, HttpStatus.OK);
    }

    @PostMapping("hesoyam")
    public ResponseEntity<String> topUpWallet(@RequestBody WalletDto topup) {
        walletService.hesoyam(topup);
        return new ResponseEntity<>("Wallet Topped Up Successfully", HttpStatus.OK);
    }
}

