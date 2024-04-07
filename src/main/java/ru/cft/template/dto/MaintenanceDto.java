package ru.cft.template.dto;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MaintenanceDto {
    private String id;
    private String type;
    private long amount;
    private long maintenanceNumber;
    private String status;
    private String transationDate;
}

