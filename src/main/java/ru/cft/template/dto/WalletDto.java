package ru.cft.template.dto;

import java.time.LocalDate;

public class WalletDto {
    private String id;
    private String billId;
    private long amount;
    private LocalDate lastUpdate;

    public WalletDto() {
    }

    public WalletDto(String id, String billId, long amount, LocalDate lastUpdate) {
        this.id = id;
        this.billId = billId;
        this.amount = amount;
        this.lastUpdate = lastUpdate;
    }

    public WalletDto(String billId, long amount) {
        this.billId = billId;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public LocalDate getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDate lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }
}
