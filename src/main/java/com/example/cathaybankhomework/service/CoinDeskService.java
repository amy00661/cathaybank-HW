package com.example.cathaybankhomework.service;

import com.example.cathaybankhomework.dto.GetCurrentPriceDto;
import com.example.cathaybankhomework.dto.GetTransferDataDto;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface CoinDeskService {

    GetCurrentPriceDto getCurrentPrice() throws JsonProcessingException;
    GetTransferDataDto getTransferData() throws JsonProcessingException;
}
