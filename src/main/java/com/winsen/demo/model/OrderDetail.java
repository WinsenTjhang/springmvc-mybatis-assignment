package com.winsen.demo.model;

import lombok.*;

import java.math.BigInteger;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetail {

    private String id;
    private String orderNo;
    private Integer seq;
    private String itemId;
    private Long price;
    private Long quantity;
    private String unit;
    private String remark;

}
