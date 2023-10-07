package com.example.cathaybankhomework;

import com.example.cathaybankhomework.controller.CoinDeskController;
import com.example.cathaybankhomework.controller.CurrencyController;
import com.example.cathaybankhomework.dto.BaseRes;
import com.example.cathaybankhomework.entity.Currency;
import com.example.cathaybankhomework.repository.CurrencyRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@SpringBootTest
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)  //指定測試方法按定義的順序執行
class CathaybankHwApplicationTests {

    @Autowired
    private CoinDeskController coinDeskController;

    @Autowired
    private CurrencyController currencyController;

    @Autowired
    private CurrencyRepository currencyRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void contextLoads() {
//        log.info("專案啟動測試");
    }
    // 1. 測試呼叫查詢幣別對應表資料API，並顯示其內容。
    @Test
//    @Order(1)
    void testGetCurrencyList() throws JsonProcessingException {
        ResponseEntity<BaseRes> response = currencyController.getCurrencyList();
        log.info(objectMapper.writeValueAsString(response));
    }

    // 2. 測試呼叫新增幣別對應表資料API。
    @Test
//    @Order(2)
    void testCreateCurrency() throws JsonProcessingException {
        List<Currency> currencyList = new ArrayList<>();
        Currency currency = new Currency();
        currency.setCode("TWD");
        currency.setName("新台幣");
        currency.setDescription("零、壹、貳、參、肆、伍、陸、柒、捌、玖、拾、佰、仟");
        currencyList.add(currency);
        Currency currency2 = new Currency();
        currency2.setCode("HKD");
        currency2.setName("港幣");
        currency2.setDescription("港元，原稱「港圓」，亦稱為「港幣」或「港紙」");
        currencyList.add(currency2);
        ResponseEntity<BaseRes> response = currencyController.createCurrencies(currencyList);

        log.info("新增資料：" + objectMapper.writeValueAsString(response));
    }

    //  3. 測試呼叫更新幣別對應表資料API，並顯示其內容。
    @Test
//    @Order(3)
    void testUpdateCurrencies() throws JsonProcessingException {
        List<Currency> currenctList = new ArrayList<>();
        Currency currency1 = currencyRepository.findById(1)
                                            .orElse(null);
        if(currency1 != null){
            currency1.setRate(BigDecimal.valueOf(111.11));
            currency1.setDescription("TEST1 TEST1 TEST1 TEST1 TEST1 ");
            currenctList.add(currency1);
        }
        Currency currency2 = currencyRepository.findById(2)
                                                .orElse(null);
        if(currency2 != null){
            currency2.setRate(BigDecimal.valueOf(222.22));
            currency2.setDescription("TEST2 TEST2 TEST2 TEST2 TEST2 ");
            currenctList.add(currency2);
        }
        ResponseEntity<BaseRes> response = currencyController.updateCurrencies(currenctList);
        log.info(objectMapper.writeValueAsString(response));
    }

    // 4. 測試呼叫刪除幣別對應表資料API。
    @Test
//    @Order(4)
    void testDeleteCurrency() throws JsonProcessingException {
        ResponseEntity<BaseRes> response = currencyController.deleteCurrency(2);
        log.info(objectMapper.writeValueAsString(response));
        this.testGetCurrencyList(); // 檢查刪除後的列表，serialNum=2是否已被刪除
    }


    // 5. 測試呼叫coindesk API，並顯示其內容。
    @Test
//    @Order(5)
    void testGetCurrentPrice() throws JsonProcessingException {
        ResponseEntity<BaseRes> response = coinDeskController.getCurrentPrice();
        log.info(objectMapper.writeValueAsString(response));
    }

    // 6. 測試呼叫資料轉換的API，並顯示其內容。
    @Test
//    @Order(6)
    void testGetTransferData() throws JsonProcessingException {
        ResponseEntity<BaseRes> response = coinDeskController.getTransferData();
        log.info(objectMapper.writeValueAsString(response));
    }
}
