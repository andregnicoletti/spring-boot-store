package com.nicoletti.store.dtos;

import java.time.LocalDate;

public final class RestErrorDTO extends GenericErrorDTO {

    public RestErrorDTO(LocalDate localDate, int status, String error, String message) {
        super(localDate, status, error, message);
    }

}
