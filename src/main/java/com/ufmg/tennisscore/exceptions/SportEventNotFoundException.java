package com.ufmg.tennisscore.exceptions;

public class SportEventNotFoundException extends TennisScoreCustomException {
    private static final int status = 404;
    private static final String message = "Não foi possível localizar o evento %s";

    public SportEventNotFoundException(int id) {
        super();

        this.setMessage(message.formatted(id));
        this.setStatus(status);
    }
}
