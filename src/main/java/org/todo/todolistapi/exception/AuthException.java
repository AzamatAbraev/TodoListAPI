package org.todo.todolistapi.exception;

public class AuthException extends RuntimeException {
    public AuthException(String message) {
        super(message);
    }
}
