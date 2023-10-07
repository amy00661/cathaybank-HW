package com.example.cathaybankhomework.controller;

import com.example.cathaybankhomework.dto.BaseRes;
import com.example.cathaybankhomework.entity.Currency;
import com.example.cathaybankhomework.service.CurrencyService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/currency")
public class CurrencyController {

    @Autowired
    CurrencyService currencyService;
    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping("getCurrencyList")
    public ResponseEntity<BaseRes> getCurrencyList() throws JsonProcessingException {

        log.info("=========getCurrencyList Start=========");
        List<Currency> resultList = currencyService.findCurrencyList();

        BaseRes res = BaseRes.buildSuccess(resultList);
        log.info("resData:{}", objectMapper.writeValueAsString(res));
        log.info("=========getCurrencyList End=========");
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("createCurrencies")
    public ResponseEntity<BaseRes> createCurrencies(@RequestBody List<Currency> currencies) throws JsonProcessingException {
        log.info("=========createCurrencies Start=========");
        currencies = currencyService.addCurrencies(currencies);

        BaseRes res = BaseRes.buildSuccess(currencies);
        log.info("resData:{}", objectMapper.writeValueAsString(res));
        log.info("=========createCurrencies End=========");
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("updateCurrencies")
    public ResponseEntity<BaseRes> updateCurrencies(@RequestBody List<Currency> currencies) throws JsonProcessingException {
        log.info("=========updateCurrencies Start=========");
        currencies = currencyService.updateCurrencies(currencies);

        BaseRes res = BaseRes.buildSuccess(currencies);
        log.info("resData:{}", objectMapper.writeValueAsString(res));
        log.info("=========updateCurrencies End=========");
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @DeleteMapping("deleteOne/{serialNum}")
    public ResponseEntity<BaseRes> deleteCurrency(@PathVariable("serialNum")Integer serialNum){
        log.info("=========deleteCurrencies Start=========");
        currencyService.deleteById(serialNum);

        BaseRes res = BaseRes.buildSuccess();
        log.info("=========deleteCurrencies End=========");
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
