package com.ite.itea.domain.dto;

public class ChairsDto extends ItemDto {

    private final int amount;

    public ChairsDto(int amount) {
        setPrice(14999L);
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

}
