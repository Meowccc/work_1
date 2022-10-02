package com.example.demo.converter;

import com.example.demo.entity.Order;
import com.example.demo.rest.dto.OrderCreateDTO;
import com.example.demo.rest.dto.OrderDTO;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

/**
 * @author meow
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, builder = @Builder(disableBuilder = true))
public interface OrderConverter {


    /**
     * converter to OrderDTO
     */
    OrderDTO toOrderDTO(Order order);

    /**
     * converter to OrderDTO
     */
    List<OrderDTO> toOrderDTO(List<Order> order);

    /**
     *
     */
    Order toOrder(OrderCreateDTO createDTO);
}
