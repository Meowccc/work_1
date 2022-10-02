package com.example.demo.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author meow
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageDataDTO<T> {

    private int pageNum;

    private int pageSize;

    private int totalCount;

    private List<T> data;
}
