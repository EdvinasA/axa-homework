package com.demo.axa.exceptions;
public class EmailInUseException extends RuntimeException {
    public EmailInUseException() {
        super("Email was already used.");
    }
}
