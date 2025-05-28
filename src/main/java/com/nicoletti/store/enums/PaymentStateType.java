package com.nicoletti.store.enums;

import lombok.Getter;

@Getter
public enum PaymentStateType {

    PENDING(1, "Pendente"),
    PAID_OFF(2, "Quitado"),
    CANCELLED(3, "Cancelado");

    private int code;
    private String description;

    private PaymentStateType(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public static PaymentStateType toEnum(Integer code) {
        if (code != null) {
            for (PaymentStateType clientType : PaymentStateType.values()) {
                if (code == clientType.code) {
                    return clientType;
                }
            }
        }
        throw new IllegalArgumentException("Invalid payment state type code: " + code);
    }
}
