package com.winsen.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    private String id;
    private String code;
    private String name;
    private Long price;
    private String unit;
    private String remark;
    private Short deleted;
    private String creator;
    private Long createTime;

}
