package com.winsen.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductSalesStatistic {

    private String itemId;
    private String code;
    private String name;
    private Long price;
    private Long quantity;
    private String unit;
}
