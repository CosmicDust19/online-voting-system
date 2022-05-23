package edu.estu.ovs.core.exception.handlers;

import edu.estu.ovs.core.results.error.ApiErrorDataResult;
import edu.estu.ovs.core.utilities.Msg;
import io.jsonwebtoken.JwtException;
import org.springframework.core.NestedRuntimeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler({NestedRuntimeException.class})
    public ResponseEntity<Object> handleNestedRuntimeException(NestedRuntimeException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ApiErrorDataResult<>(ex, HttpStatus.INTERNAL_SERVER_ERROR, ex.getMostSpecificCause().getLocalizedMessage()));
    }

    @ExceptionHandler({JwtException.class})
    public ResponseEntity<Object> handleJwtException(JwtException x) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(new ApiErrorDataResult<>(x, HttpStatus.UNAUTHORIZED, Msg.JWT_EXPIRED));
    }

}
