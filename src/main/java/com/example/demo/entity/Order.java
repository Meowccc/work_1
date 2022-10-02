package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @author meow
 */
@Setter
@Getter
@Entity
@Table(name = "member_order")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order extends BaseEntity{

    @Column(name = "member_id")
    private String memberId;

    @Column(name = "order_no")
    private String orderNo;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "product_id")
    private String productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "description")
    private String description;
}
