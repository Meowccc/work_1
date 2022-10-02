package com.example.demo.rest.controller;

import com.example.demo.rest.dto.OrderDTO;
import com.example.demo.rest.dto.PageDataDTO;
import com.example.demo.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

/**
 * @author meow
 */
@RestController
@RequestMapping("orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public PageDataDTO<OrderDTO> listOrders(@RequestParam(value = "page", defaultValue = "0") int page,
                                            @RequestParam(value = "size", defaultValue = "5") int size,
                                            @RequestParam(value = "keyword", required = false) String keyword,
                                            @RequestParam(value = "startDate", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
                                            @RequestParam(value = "endDate", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate
    ) {
        return orderService.listOrders(page, size, keyword, startDate, endDate);
    }

    @PostMapping("product/{id}")
    public OrderDTO create(@PathVariable("id") String productId) {
        return orderService.create(productId);
    }
}
