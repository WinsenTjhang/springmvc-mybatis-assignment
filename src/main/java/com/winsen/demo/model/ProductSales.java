package com.winsen.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductSales {

    private String id;
    private String code;
    private String name;
    private Long price;
    private String unit;
    private Long quantity;


}
