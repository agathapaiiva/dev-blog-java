package br.com.blog.app.configuration.handler;

import br.com.blog.app.dataprovider.dto.ResponseDTO;
import br.com.blog.core.domain.exception.InvalidCategoryException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionConfigHandler {

    @ExceptionHandler({InvalidCategoryException.class})
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<ResponseDTO> handleStudentNotFoundException(InvalidCategoryException e) {

        var responseException = ResponseDTO.builder()
                .code(HttpStatus.CONFLICT.value())
                .message(e.getMessage())
                .build();

        return new ResponseEntity<>(responseException, HttpStatus.CONFLICT);
    }
}
