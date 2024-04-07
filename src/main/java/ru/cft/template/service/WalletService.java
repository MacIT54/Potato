package ru.cft.template.service;

import ru.cft.template.dto.WalletDto;

public interface WalletService {
    void create (WalletDto wallet);
    WalletDto findById(String id);

    void hesoyam(WalletDto topup);
}
