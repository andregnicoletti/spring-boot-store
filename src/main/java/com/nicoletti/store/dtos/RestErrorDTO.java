package com.nicoletti.store.dtos;

import java.time.LocalDate;

public record RestErrorDTO(LocalDate timestamp, int status, String error, String message) {
}
