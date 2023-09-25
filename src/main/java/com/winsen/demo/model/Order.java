package com.winsen.demo.model;

import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private String id;
    private int bizDate;
    private String orderNo;
    private Short status;
    private String remark;
    private String creator;
    private Long createTime;

}
