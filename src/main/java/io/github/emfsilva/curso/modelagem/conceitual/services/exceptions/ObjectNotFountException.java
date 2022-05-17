package io.github.emfsilva.curso.modelagem.conceitual.services.exceptions;

public class ObjectNotFountException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ObjectNotFountException(String msg) {
        super(msg);
    }

    public ObjectNotFountException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
