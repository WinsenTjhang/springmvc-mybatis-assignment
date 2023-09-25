package com.winsen.demo.DTO;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CreateOrderRequest {
    private String userId;
    private String itemId;
    private Long price;
    private Long quantity;
    private String remark;

}
