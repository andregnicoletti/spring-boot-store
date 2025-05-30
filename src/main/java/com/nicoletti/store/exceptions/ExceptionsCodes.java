package com.nicoletti.store.exceptions;

public interface ExceptionsCodes {

    // CATEGORY SERVICE
    String ID_CATEGORY_DOES_NOT_EXISTS = "CAT-001";
    String CATEGORY_NAME_ALREADY_EXISTS = "CAT-002";
    String COULD_NOT_DELETE_CATEGORY = "CAT-003";

    // CLIENT SERVICE
    String CLIENT_ID_DOES_NOT_EXISTS = "CLI-001";

    // ORDER SERVICE
    String ORDER_ID_DOES_NOT_EXISTS = "ORD-001";
}
