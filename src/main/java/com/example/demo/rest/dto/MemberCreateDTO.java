package com.example.demo.rest.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author meow
 */
@Data
public class MemberCreateDTO {

    @NotEmpty
    private String name;
}
