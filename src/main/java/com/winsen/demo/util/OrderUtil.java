package com.winsen.demo.util;

import com.winsen.demo.model.Status;

public class OrderUtil {

    public static String generateOrderNumber() {
        return "s" + DateUtil.generateDate();
    }

    public static String convertStatus(Short status) {
        String statusMessage = null;
        switch (status) {
            case 1:
                statusMessage = String.valueOf(Status.PENDING_PAYMENT);
                break;
            case  2:
                statusMessage = String.valueOf(Status.PAID);
                break;
            case  3:
                statusMessage = String.valueOf(Status.PAYMENT_FAILED);
                break;
            case  4:
                statusMessage = String.valueOf(Status.REFUND);
                break;
        }
        return statusMessage;
    }
}
