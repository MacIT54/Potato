package ru.cft.template.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.cft.template.dto.CashTransfersDto;
import ru.cft.template.dto.MaintenanceDto;
import ru.cft.template.service.CashTransfersService;

import java.util.List;

@RestController
@RequestMapping
public class CashTransfersController {

    private final CashTransfersService cashTransfersService;

    public CashTransfersController(CashTransfersService cashTransfersService) {
        this.cashTransfersService = cashTransfersService;
    }

    @GetMapping("/history/{userId}")
    public ResponseEntity<List<CashTransfersDto>> getTransfersHistory(@PathVariable String userId) {
        List<CashTransfersDto> history = cashTransfersService.getHistory(userId);
        return ResponseEntity.ok(history);
    }

    @PostMapping("/transfers")
    public ResponseEntity<String> sendTransfer(@RequestBody @Valid CashTransfersDto dto) {
        cashTransfersService.transfer(dto);
        return ResponseEntity.ok("Transfer sent successfully");
    }

    @GetMapping("/maintenance/{userId}")
    public ResponseEntity<List<MaintenanceDto>> getMaintenance(@PathVariable String userId) {
        List<MaintenanceDto> maintenance = cashTransfersService.getMaintenance(userId);
        return ResponseEntity.ok(maintenance);
    }

    @PostMapping("/maintenance")
    public ResponseEntity<String> generateMaintenance(@RequestBody @Valid MaintenanceDto dto) {
        cashTransfersService.generateMaintenance(dto);
        return ResponseEntity.ok("Maintenance generated successfully");
    }
}


