package com.nicoletti.store.controllers;

import com.nicoletti.store.dtos.RestErrorDTO;
import com.nicoletti.store.exceptions.ServiceException;
import com.nicoletti.store.exceptions.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;

@RestControllerAdvice
public class ExceptionHandleController {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<RestErrorDTO> entityNotFoundException(EntityNotFoundException e, HttpServletRequest request) {
        RestErrorDTO body = new RestErrorDTO(
                LocalDate.now(),
                HttpStatus.NOT_FOUND.value(),
                "Entity not found",
                e.getMessage()
        );
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<RestErrorDTO> serviceException(ServiceException e, HttpServletRequest request) {
        RestErrorDTO body = new RestErrorDTO(
                LocalDate.now(),
                HttpStatus.BAD_REQUEST.value(),
                "Entity could not be deleted.",
                e.getMessage()
        );
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }


}
