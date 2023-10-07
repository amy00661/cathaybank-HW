package com.example.cathaybankhomework.service.impl;

import com.example.cathaybankhomework.dto.GetCurrentPriceDto;
import com.example.cathaybankhomework.dto.GetTransferDataDto;
import com.example.cathaybankhomework.service.CoinDeskService;
import com.example.cathaybankhomework.util.DateUtil;
import com.example.cathaybankhomework.util.MemoryDataUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Slf4j
@Service
public class CoinDeskServiceImpl implements CoinDeskService {

    @Value("${coindesk.api.url}")
    private String CURRENT_PRICE_URL;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public GetCurrentPriceDto getCurrentPrice() throws JsonProcessingException {
        // 呼叫coindesk api取回json字串
        String jsonString = callCurrentPriceApi();
        GetCurrentPriceDto currentPriceDto = objectMapper.readValue(jsonString, GetCurrentPriceDto.class);
        return currentPriceDto;
    }

    @Override
    public GetTransferDataDto getTransferData() throws JsonProcessingException {
        // 呼叫coindesk api取回json字串
        String jsonString = callCurrentPriceApi();
        GetCurrentPriceDto originObj = objectMapper.readValue(jsonString, GetCurrentPriceDto.class);
        GetTransferDataDto newObj = new GetTransferDataDto();
        newObj.setUpdateTime(DateUtil.transUTCToNormalDate(originObj.getTime().getUpdatedISO(),
                                                            "yyyy/MM/dd HH:mm:ss"));

        Map<String, GetCurrentPriceDto.BpiDto> originBpi = originObj.getBpi();
        if(originBpi != null){
            originBpi.forEach((key, value) -> {
                GetTransferDataDto.CurrencyDto currencyDto = new GetTransferDataDto.CurrencyDto();
                currencyDto.setCode(value.getCode());
                currencyDto.setName(MemoryDataUtil.currencyMap.get(value.getCode()));
                currencyDto.setRateFloat(value.getRateFloat());
                newObj.getCurrency().put(value.getCode(), currencyDto);
            });
        }
        return newObj;
    }

    //  呼叫幣值匯率api，取回JSON字串
    String callCurrentPriceApi() throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();

        // Fetch JSON response as String wrapped in ResponseEntity
        ResponseEntity<String> response
                = restTemplate.getForEntity(CURRENT_PRICE_URL, String.class);

        String jsonString = response.getBody();
        log.info("jsonString=" + jsonString);
        return jsonString;
    }
}
