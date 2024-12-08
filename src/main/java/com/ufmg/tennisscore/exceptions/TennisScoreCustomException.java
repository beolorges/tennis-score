package com.ufmg.tennisscore.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class TennisScoreCustomException extends RuntimeException {
    private String message;
    private int status;
    private String code;

    protected TennisScoreCustomException(){}
}
