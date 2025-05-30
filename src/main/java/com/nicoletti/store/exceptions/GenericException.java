package com.nicoletti.store.exceptions;

import com.nicoletti.store.utils.MessageUtils;

public class GenericException extends RuntimeException {

    private final String code;
    private final Object[] args;

    public GenericException(String code) {
        this(code, null);
    }

    public GenericException(String code, Object... args) {
        super(MessageUtils.t(code, args));
        this.code = code;
        this.args = args;
    }

    public String getCode() {
        return code;
    }

    public Object[] getArgs() {
        return args;
    }
}
