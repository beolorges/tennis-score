package com.ufmg.tennisscore.controller.advice;

import com.ufmg.tennisscore.exceptions.TennisScoreCustomException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TennisScoreCustomExceptionAdvisor {
    @ExceptionHandler(value = TennisScoreCustomException.class)
    public ResponseEntity<ErrorResponse> objectNotFound(TennisScoreCustomException tennisScoreCustomException){
        ErrorResponse errorResponse = ErrorResponse.builder()
                .code(tennisScoreCustomException.getCode())
                .message(tennisScoreCustomException.getMessage())
                .build();

        return ResponseEntity
                .status(tennisScoreCustomException.getStatus())
                .body(errorResponse);
    }

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<ErrorResponse> runTimeException(RuntimeException runtimeException){
        ErrorResponse errorResponse = ErrorResponse.builder()
                .message("Houve um erro desconhecido. Estamos trabalhando para resolvê-lo.")
                .code("ERR000")
                .build();

        return ResponseEntity
                .status(500)
                .body(errorResponse);
    }

}
