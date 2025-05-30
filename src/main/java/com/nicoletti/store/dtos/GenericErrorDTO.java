package com.nicoletti.store.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public abstract class GenericErrorDTO {

    private LocalDate localDate;
    private int status;
    private String error;
    private String message;

}
