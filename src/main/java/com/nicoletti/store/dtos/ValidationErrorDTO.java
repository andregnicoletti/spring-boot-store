package com.nicoletti.store.dtos;

import lombok.Getter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
public class ValidationErrorDTO extends GenericErrorDTO {

    private List<ValidationDTO> errors = new ArrayList<>();

    public ValidationErrorDTO(LocalDate localDate, int status, String error, String message) {
        super(localDate, status, error, message);
    }

    public void addErrors(String fieldName, String message) {
        this.errors.add(new ValidationDTO(fieldName, message));
    }

}
