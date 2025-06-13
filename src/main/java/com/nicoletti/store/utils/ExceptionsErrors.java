package com.nicoletti.store.utils;

public interface ExceptionsErrors {

    // CATEGORY SERVICE
    String ID_CATEGORY_DOES_NOT_EXISTS = "CAT-001";
    String CATEGORY_NAME_ALREADY_EXISTS = "CAT-002";
    String COULD_NOT_DELETE_CATEGORY = "CAT-003";

    // CLIENT SERVICE
    String CLIENT_ID_DOES_NOT_EXISTS = "CLI-001";
    String CLIENT_NAME_ALREADY_EXISTS = "CLI-002";
    String COULD_NOT_DELETE_CLIENT = "CLI-003";

    // ORDER SERVICE
    String ORDER_ID_DOES_NOT_EXISTS = "ORD-001";

    // PRODUC SERVICE
    String PRODUCT_ID_DOES_NOT_EXISTS = "PRO-001";

    // VALIDATIONS
    String GENERAL_VALIDATION_ERROR = "VLD-001";
}
