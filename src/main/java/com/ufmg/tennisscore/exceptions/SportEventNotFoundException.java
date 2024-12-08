package com.ufmg.tennisscore.exceptions;

public class SportEventNotFoundException extends TennisScoreCustomException {
    private static final int status = 404;
    private static final String message = "Não foi possível localizar o evento %s";
    private static final String code = "ERR001";

    public SportEventNotFoundException(int id) {
        super();

        this.setMessage(message.formatted(id));
        this.setStatus(status);
        this.setCode(code);
    }
}
