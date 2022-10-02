package com.example.demo.repository;

import com.example.demo.entity.Order;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Optional;

/**
 * @author meow
 */
public interface OrderRepo extends BaseRepo<Order, String> {

    List<Order> findByMemberId(String memberId);
}
