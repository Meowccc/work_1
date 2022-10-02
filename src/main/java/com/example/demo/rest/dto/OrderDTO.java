package com.example.demo.rest.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author meow
 */
@Data
public class OrderDTO {

    private String id;

    private String orderNo;

    private String memberId;

    private BigDecimal amount;

    private String productId;

    private String productName;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
