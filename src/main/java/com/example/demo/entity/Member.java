package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author meow
 */
@Setter
@Getter
@Entity
@Table(name = "member")
public class Member extends BaseEntity{

    private String name;
}
