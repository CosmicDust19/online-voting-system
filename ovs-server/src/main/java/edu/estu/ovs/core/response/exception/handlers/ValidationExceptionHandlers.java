package edu.estu.ovs.core.response.exception.handlers;

import edu.estu.ovs.core.response.results.error.ApiErrorResult;
import edu.estu.ovs.core.response.results.abstracts.ApiSubError;
import edu.estu.ovs.core.response.results.error.suberrors.ApiValidationError;
import edu.estu.ovs.core.utilities.Msg;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@ControllerAdvice
public class ValidationExceptionHandlers {

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        Stream<ApiSubError> fieldErrors = ex.getFieldErrors().stream()
                .map(err -> new ApiValidationError(err.getObjectName(), err.getField(), err.getRejectedValue(), err.getDefaultMessage()));
        Stream<ApiSubError> objErrors = ex.getGlobalErrors().stream()
                .map(err -> new ApiValidationError(err.getObjectName(), err.getDefaultMessage()));
        return ResponseEntity.badRequest().body(new ApiErrorResult<>(ex, Msg.INVALID, Stream.concat(fieldErrors, objErrors).collect(Collectors.toList())));
    }

    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException ex) {
        List<ApiSubError> errors = ex.getConstraintViolations().stream()
                .map(err -> new ApiValidationError(err.getPropertyPath(), err.getInvalidValue(), err.getMessage()))
                .collect(Collectors.toList());
        return ResponseEntity.badRequest().body(new ApiErrorResult<>(ex, Msg.INVALID, errors));
    }

}
