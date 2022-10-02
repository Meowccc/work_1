package com.example.demo.rest.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author meow
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class MemberDetailDTO extends MemberDTO{

    private String description;
}
