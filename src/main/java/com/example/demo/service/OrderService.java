package com.example.demo.service;

import com.example.demo.converter.OrderConverter;
import com.example.demo.entity.Order;
import com.example.demo.entity.Product;
import com.example.demo.repository.OrderRepo;
import com.example.demo.rest.dto.OrderDTO;
import com.example.demo.rest.dto.PageDataDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;

import javax.persistence.criteria.Predicate;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

/**
 * @author meow
 */
@Service
@Validated
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderService extends BaseService{

    @Value("${fake-data.member-id:}")
    private String memberId;

    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");

    private final Random random;

    private final OrderRepo orderRepo;
    private final OrderConverter orderConverter;


    /**
     * TODO remove hardcode userId
     * TODO userId get from SecurityContextHolder
     */
    public PageDataDTO<OrderDTO> listOrders(final int pageNum, final int pageSize, final String keyword, final LocalDate startDate, final LocalDate endDate) {



        Specification<Order> specification = (root, query, cb) -> {

            final List<Predicate> predicates = new ArrayList<>();
            predicates.add(cb.equal(root.get("memberId"), memberId));

            if(StringUtils.hasText(keyword)) {
                predicates.add(cb.or(cb.equal(root.get("orderNo"), keyword), cb.equal(root.get("productName"), keyword)));
            }

            if(startDate != null && endDate != null) {
//                predicates.add(cb.between(root.get("createdAt"), startDate.atStartOfDay(), endDate.atStartOfDay()));
                predicates.add(cb.greaterThanOrEqualTo(root.get("createdAt"), startDate.atStartOfDay()));
                predicates.add(cb.lessThanOrEqualTo(root.get("createdAt"), endDate.atStartOfDay()));
            }
            return cb.and(predicates.toArray(new Predicate[0]));
        };

        final Page<Order> orderPage = orderRepo.findAll(specification, PageRequest.of(pageNum, pageSize));
        return convert(orderPage,orderConverter.toOrderDTO(orderPage.getContent()));
    }

    /**
     *
     */
    @Transactional
    public OrderDTO create(@NotEmpty final String productId) {

        // TODO find product (fake Product)
        final Product product = Optional.ofNullable(new Product(productId, "Product", new BigDecimal(100))).orElseThrow();

        final String nowStr = dateFormatter.format(LocalDate.now());
        final String orderNo = "OD".concat(nowStr).concat(String.format("%06d", random.nextInt(999999)));

        final Order order = orderRepo.saveAndFlush(Order.builder()
                .orderNo(orderNo)
                .memberId(memberId)
                .productId(product.getId())
                .productName(product.getName())
                .amount(product.getAmount())
                .build());

        return orderConverter.toOrderDTO(orderRepo.save(order));
    }

}
