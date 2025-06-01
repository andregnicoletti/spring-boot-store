package com.nicoletti.store.exceptions;

import com.nicoletti.store.dtos.GenericErrorDTO;
import com.nicoletti.store.dtos.RestErrorDTO;
import com.nicoletti.store.dtos.ValidationErrorDTO;
import com.nicoletti.store.utils.ExceptionsErrors;
import com.nicoletti.store.utils.MessageUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;

@RestControllerAdvice
public class ExceptionHandleController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrorDTO> entityNotFoundException(MethodArgumentNotValidException e, HttpServletRequest request) {

        ValidationErrorDTO body = new ValidationErrorDTO(
                LocalDate.now(),
                HttpStatus.BAD_REQUEST.value(),
                ExceptionsErrors.GENERAL_VALIDATION_ERROR,
                MessageUtils.t(ExceptionsErrors.GENERAL_VALIDATION_ERROR)
        );
        e.getBindingResult().getFieldErrors().stream().forEach(err -> body.addErrors(err.getField(), err.getCode()));
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(GenericException.class)
    public ResponseEntity<GenericErrorDTO> serviceException(GenericException e, HttpServletRequest request) {
        GenericErrorDTO body = new RestErrorDTO(
                LocalDate.now(),
                HttpStatus.BAD_REQUEST.value(),
                e.getCode(),
                e.getMessage()
        );
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }


}
