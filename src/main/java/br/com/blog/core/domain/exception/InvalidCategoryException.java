package br.com.blog.core.domain.exception;

public class InvalidCategoryException extends RuntimeException{

    public InvalidCategoryException(final String message) {
        super(message);
    }
}