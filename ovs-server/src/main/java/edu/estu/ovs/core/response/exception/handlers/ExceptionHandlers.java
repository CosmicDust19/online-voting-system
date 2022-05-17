package edu.estu.ovs.core.response.exception.handlers;

import edu.estu.ovs.core.response.results.error.ApiErrorResult;
import org.springframework.core.NestedRuntimeException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler({NestedRuntimeException.class})
    public ResponseEntity<Object> handleNestedRuntimeException(NestedRuntimeException ex) {
        return ResponseEntity.badRequest().body(new ApiErrorResult<>(ex, ex.getMostSpecificCause().getLocalizedMessage()));
    }

}
