package com.example.cathaybankhomework.service;

import com.example.cathaybankhomework.entity.Currency;

import java.util.List;

public interface CurrencyService {
    List<Currency> findCurrencyList();

    List<Currency> addCurrencies(List<Currency> currencies);

    List<Currency> updateCurrencies(List<Currency> currency);

    void deleteById(Integer id);
}
