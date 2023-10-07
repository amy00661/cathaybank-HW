package com.example.cathaybankhomework.dto;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class GetTransferDataDto {

    private String updateTime;
    private Map<String, CurrencyDto> currency = new HashMap<>();

    @Data
    public static class CurrencyDto {
        private String code;
        private String name;
        private Double rateFloat;
    }
}
