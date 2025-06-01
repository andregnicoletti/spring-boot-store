package com.nicoletti.store.utils;

public interface ValidationMessages {

    interface Category {
        String NAME_REQUIRED = "validation.category.name.notEmpty";
        String NAME_LENGTH = "validation.category.name.length";
    }

    interface Client {
        String NAME_REQUIRED = "validation.client.name.notEmpty";
        String NAME_LENGTH = "validation.client.name.length";
        String EMAIL_REQUIRED = "validation.client.email.notEmpty";
        String EMAIL_INVALID = "validation.client.email.invalid";
        String DOCUMENT_REQUIRED = "validation.client.document.notEmpty";
    }

    interface Address {
        String STREET_REQUIRED = "validation.address.street.notEmpty";
        String NUMBER_REQUIRED = "validation.address.number.notEmpty";
        String NEIGHBORHOOD_REQUIRED = "validation.address.neighborhood.notEmpty";
        String POSTAL_CODE_REQUIRED = "validation.address.postal.code.notEmpty";
    }
}

