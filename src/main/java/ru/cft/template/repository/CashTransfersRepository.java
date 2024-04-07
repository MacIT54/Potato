package ru.cft.template.repository;


import ru.cft.template.dto.CashTransfersDto;
import ru.cft.template.dto.MaintenanceDto;

import java.util.List;

public interface CashTransfersRepository {
    List<CashTransfersDto> getTransfersHistory(String userId);

    void sendTransfer(CashTransfersDto dto);

    List<MaintenanceDto> getMaintenance(String userId);

    void generateMaintenance(MaintenanceDto dto);
}
