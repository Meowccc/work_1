package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author meow
 */
@Data
@AllArgsConstructor
public class Product {

    private String id;

    private String name;

    private BigDecimal amount;
}
