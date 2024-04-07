package ru.cft.template.repository.impl;

import org.springframework.stereotype.Repository;
import ru.cft.template.dto.CashTransfersDto;
import ru.cft.template.dto.MaintenanceDto;
import ru.cft.template.dto.WalletDto;
import ru.cft.template.repository.CashTransfersRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CashTransfersRepositoryImpl implements CashTransfersRepository {

    private final Map<String, CashTransfersDto> transfersMap = new HashMap<>();

    private final Map<String, MaintenanceDto> maintenanceMap = new HashMap<>();

    @Override
    public List<CashTransfersDto> getTransfersHistory(String userId) {
        return new ArrayList<>(transfersMap.values());
    }

    @Override
    public void sendTransfer(CashTransfersDto dto) {
        String walletId = String.valueOf(dto.getId());
        CashTransfersDto dtoToSend = new CashTransfersDto();
        WalletDto wallet = new WalletDto();
        wallet.setId("5");
        wallet.setAmount(4553);
        dtoToSend.setId(dto.getId());
        dtoToSend.setUserId(dto.getUserId());
        dtoToSend.setWallet(wallet);
        transfersMap.put(walletId, dtoToSend);
    }

    @Override
    public List<MaintenanceDto> getMaintenance(String userId) {
        return new ArrayList<>(maintenanceMap.values());
    }

    @Override
    public void generateMaintenance(MaintenanceDto dto) {
        String id = String.valueOf(dto.getId());
        MaintenanceDto dtoToSend = new MaintenanceDto();
        dtoToSend.setId(id);
        dtoToSend.setType(dto.getType());
        dtoToSend.setAmount(dto.getAmount());
        dtoToSend.setMaintenanceNumber(dto.getMaintenanceNumber());
        dtoToSend.setStatus(dto.getStatus());
        dtoToSend.setTransationDate(dto.getTransationDate());
        maintenanceMap.put(id, dtoToSend);
    }
}
