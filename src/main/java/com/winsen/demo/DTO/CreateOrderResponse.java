package com.winsen.demo.DTO;

import com.winsen.demo.util.OrderUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderResponse {

    private String orderId;
    private String orderNo;
    private int bizDate;
    private Short status;

    public String getStatus() {
        return OrderUtil.convertStatus(status);
    }

}
