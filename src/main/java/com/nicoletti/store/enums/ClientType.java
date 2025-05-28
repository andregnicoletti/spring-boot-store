package com.nicoletti.store.enums;

import lombok.Getter;

@Getter
public enum ClientType {

    PHYSICAL_PERSON(1, "Pessoa Física"),
    LEGAL_ENTITY(2, "Pessoa Jurídica");

    private int code;
    private String description;

    private ClientType(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public static ClientType toEnum(Integer code) {
        if (code != null) {
            for (ClientType clientType : ClientType.values()) {
                if (code == clientType.code) {
                    return clientType;
                }
            }
        }
        throw new IllegalArgumentException("Invalid client type code: " + code);
    }
}
