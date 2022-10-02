package com.example.demo.service;

import com.example.demo.rest.dto.PageDataDTO;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author meow
 */
public abstract class BaseService {

    protected <T, E> PageDataDTO<T> convert(final Page<E> page, final List<T> list) {
        return PageDataDTO.<T>builder()
                .pageNum(page.getNumber())
                .pageSize(page.getSize())
                .totalCount(page.getNumberOfElements())
            .data(list)
            .build();
    }

    protected <T, E> PageDataDTO<T> converter(final Page<E> page, final Function<E, T> func) {
        return PageDataDTO.<T>builder()
                .pageNum(page.getNumber())
                .pageSize(page.getSize())
                .totalCount(page.getNumberOfElements())
                .data(page.getContent().stream().map(func).collect(Collectors.toList()))
                .build();
    }
}
