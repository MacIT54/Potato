package ru.cft.template.service;

import org.springframework.stereotype.Service;
import ru.cft.template.dto.CashTransfersDto;
import ru.cft.template.dto.MaintenanceDto;

import java.util.List;

@Service
public interface CashTransfersService {

    List<CashTransfersDto> getHistory(String userId);

    void transfer(CashTransfersDto dto);

    List<MaintenanceDto> getMaintenance(String userId);

    void generateMaintenance(MaintenanceDto dto);

}
