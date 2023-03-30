package org.echo.web.exception;

public class AuthorNotFoundException extends RuntimeException {

    public AuthorNotFoundException() {
        super();
    }

    public AuthorNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public AuthorNotFoundException(final String message) {
        super(message);
    }

    public AuthorNotFoundException(final Throwable cause) {
        super(cause);
    }
}
