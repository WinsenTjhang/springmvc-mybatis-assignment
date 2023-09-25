package com.winsen.demo.model;

public enum Status {
    PENDING_PAYMENT((short) 1),
    PAID((short) 2),
    PAYMENT_FAILED((short) 3),
    REFUND((short) 4);

    private final Short statusShort;

    Status(Short statusShort) {
        this.statusShort = statusShort;
    }

    public Short getStatusShort() {
        return this.statusShort;
    }


}
