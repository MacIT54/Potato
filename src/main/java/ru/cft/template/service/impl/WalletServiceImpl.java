package ru.cft.template.service.impl;

import org.springframework.stereotype.Service;
import ru.cft.template.dto.WalletDto;
import ru.cft.template.service.WalletService;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Service
public class WalletServiceImpl implements WalletService {

    private final Map<String, WalletDto> walletMap = new HashMap<>();

    private static int counter = 0;

    @Override
    public void create(WalletDto wallet) {
        counter += 1;
        String walletId = String.valueOf(counter);
        wallet.setId(walletId);
        wallet.setBillId(walletId);
        wallet.setLastUpdate(LocalDate.of(2023, 1, 1));
        walletMap.put(walletId, wallet);
    }

    @Override
    public void hesoyam(WalletDto topup) {
        topup.setBillId(topup.getId());
        String id = topup.getId();
        walletMap.put(id, topup);
    }

    @Override
    public WalletDto findById(String id) {
        return walletMap.get(id);
    }

}
