package com.example.cathaybankhomework.controller;

import com.example.cathaybankhomework.dto.BaseRes;
import com.example.cathaybankhomework.dto.GetCurrentPriceDto;
import com.example.cathaybankhomework.dto.GetTransferDataDto;
import com.example.cathaybankhomework.service.CoinDeskService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/coinDesk")
public class CoinDeskController{
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CoinDeskService coinDeskService;
    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping("getCurrentPrice")
    public ResponseEntity<BaseRes> getCurrentPrice() throws JsonProcessingException {
        logger.info("=========getCurrentPrice Start=========");
        GetCurrentPriceDto resultData = coinDeskService.getCurrentPrice();

        BaseRes res = BaseRes.buildSuccess(resultData);
        logger.debug("resData:{}", objectMapper.writeValueAsString(res));
        logger.info("=========getCurrentPrice End=========");
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("getTransferData")
    public ResponseEntity<BaseRes> getTransferData() throws JsonProcessingException {
        logger.info("=========getTransferData Start=========");
        GetTransferDataDto resultData = coinDeskService.getTransferData();

        BaseRes res = BaseRes.buildSuccess(resultData);
        logger.debug("resData:{}", objectMapper.writeValueAsString(res));
        logger.info("=========getTransferData End=========");
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
