package ru.cft.template.dto;

import lombok.*;

import java.util.HashSet;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CashTransfersDto {
    private String id;
    private String userId;
    private long amount;
    private String transationDate;
    private String type;
    private long recieverPhone;
    private long maintenanceNumber;
    private String status;
    private WalletDto wallet;
}
