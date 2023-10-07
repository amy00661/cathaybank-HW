package com.example.cathaybankhomework.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

@Data
public class GetCurrentPriceDto {

    private TimeDto time;
    private String disclaimer;
    private String chartName;
    private Map<String, BpiDto> bpi;

    @Data
    public static class TimeDto {
        private String updated;
        private String updatedISO;
        private String updateduk;
    }

    @Data
    public static class BpiDto {
        private String code;
        private String symbol;
        private String rate;
        private String description;
        @JsonProperty("rate_float")
        private Double rateFloat;
    }
}
