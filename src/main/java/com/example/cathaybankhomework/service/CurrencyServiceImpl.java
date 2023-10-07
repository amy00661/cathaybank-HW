package com.example.cathaybankhomework.service;

import com.example.cathaybankhomework.entity.Currency;
import com.example.cathaybankhomework.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    @Autowired
    private CurrencyRepository currencyRepository;

    @Override
    public List<Currency> findCurrencyList() {
        return currencyRepository.findAll();
    }

    @Override
    public List<Currency> addCurrencies(List<Currency> currencies) {
        return currencyRepository.saveAll(currencies);
    }

    @Override
    public List<Currency> updateCurrencies(List<Currency> currencies) {
        return currencyRepository.saveAll(currencies);
    }

    @Override
    public void deleteById(Integer serialNum) {
        currencyRepository.deleteById(serialNum);
    }
}
