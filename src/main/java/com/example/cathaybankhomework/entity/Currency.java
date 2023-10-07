package com.example.cathaybankhomework.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "CURRENCY")
public class Currency {
    @Id
    @Column(name = "serial_num")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int serialNum;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "symbol")
    private String symbol;

    @Column(name = "rate")
    private BigDecimal rate;

    @Column(name = "description")
    private String description;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "update_time")
    private LocalDateTime updateTime = LocalDateTime.now();

    // The JPA will take care of the field "update_date", so programmers don't need to take care of it anymore.
    @PreUpdate
    @PrePersist
    public void updateUpdateTime() {
        this.updateTime = LocalDateTime.now();
    }
}
