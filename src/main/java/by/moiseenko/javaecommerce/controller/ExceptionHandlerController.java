package by.moiseenko.javaecommerce.controller;

/*
    @author Ilya Moiseenko on 28.01.24
*/

import by.moiseenko.javaecommerce.domain.dto.response.Error;
import by.moiseenko.javaecommerce.exception.EntityNotFoundException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
                                                                  HttpStatusCode status,
                                                                  WebRequest request) {
        Error apiError = new Error(HttpStatus.BAD_REQUEST);
        apiError.setMessage("Validation error");
        apiError.addValidationErrors(ex.getBindingResult().getFieldErrors());
        apiError.addValidationError(ex.getBindingResult().getGlobalErrors());

        return buildResponseEntity(apiError);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    protected ResponseEntity<Object> handleDataIntegrityViolation(DataIntegrityViolationException ex,
                                                                  WebRequest request) {
        if (ex.getCause() instanceof ConstraintViolationException) {
            return buildResponseEntity(
                    new Error(
                            HttpStatus.CONFLICT,
                            "Database error",
                            ex.getCause()
                    )
            );
        }

        return buildResponseEntity(new Error(HttpStatus.INTERNAL_SERVER_ERROR, ex));
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleEntityNotFoundException(EntityNotFoundException e) {
        return new ResponseEntity<>(
                "Message: " + e.getMessage(),
                HttpStatus.BAD_REQUEST
        );
    }

    private ResponseEntity<Object> buildResponseEntity(Error apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }
}
