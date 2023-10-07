package com.example.cathaybankhomework.repository;

import com.example.cathaybankhomework.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Integer> {
    @Override
    List<Currency> findAll();
    @Override
    <S extends Currency> List<S> saveAll(Iterable<S> entities);

    @Override
    void deleteById(Integer integer);

    @Override
    Optional<Currency> findById(Integer integer);
}
