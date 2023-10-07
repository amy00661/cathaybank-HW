package com.example.cathaybankhomework.service.impl;

import com.example.cathaybankhomework.entity.Currency;
import com.example.cathaybankhomework.repository.CurrencyRepository;
import com.example.cathaybankhomework.service.MemoryDataService;
import com.example.cathaybankhomework.util.MemoryDataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class MemoryDataServiceImpl implements MemoryDataService {

    @Autowired
    CurrencyRepository currencyRepository;

    @PostConstruct
    public void init(){
        List<Currency> currencyList = currencyRepository.findAll();
        if(!ObjectUtils.isEmpty(currencyList)){
            MemoryDataUtil.currencyMap.clear();
            currencyList.forEach(currency -> {
                MemoryDataUtil.currencyMap.put(currency.getCode(), currency.getName());
            });
        }
    }
}
