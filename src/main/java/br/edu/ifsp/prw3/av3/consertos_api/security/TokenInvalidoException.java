package br.edu.ifsp.prw3.av3.consertos_api.security;

public class TokenInvalidoException extends RuntimeException {
    public TokenInvalidoException(String message) {
        super(message);
    }
}
