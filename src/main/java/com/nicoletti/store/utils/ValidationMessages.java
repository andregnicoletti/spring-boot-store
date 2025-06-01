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
    }
}

