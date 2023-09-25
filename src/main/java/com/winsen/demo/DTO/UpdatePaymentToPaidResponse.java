package com.winsen.demo.DTO;

import com.winsen.demo.util.OrderUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdatePaymentToPaidResponse {

    private String orderId;
    private Short status;

    public String getStatus() {
        return OrderUtil.convertStatus(status);
    }

}
