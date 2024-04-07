package ru.cft.template.service.impl;

import org.springframework.stereotype.Service;
import ru.cft.template.dto.CashTransfersDto;
import ru.cft.template.dto.MaintenanceDto;
import ru.cft.template.repository.CashTransfersRepository;
import ru.cft.template.service.CashTransfersService;

import java.util.List;

@Service
public class CashTransfersServiceImpl implements CashTransfersService {
    private final CashTransfersRepository repository;

    public CashTransfersServiceImpl(CashTransfersRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<CashTransfersDto> getHistory(String userId) {
        return repository.getTransfersHistory(userId);
    }

    @Override
    public void transfer(CashTransfersDto dto) {
        repository.sendTransfer(dto);
    }

    @Override
    public List<MaintenanceDto> getMaintenance(String userId) {
        return repository.getMaintenance(userId);
    }

    @Override
    public void generateMaintenance(MaintenanceDto dto) {
        repository.generateMaintenance(dto);
    }


}
