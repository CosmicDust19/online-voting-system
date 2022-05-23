package edu.estu.ovs.core.results.error;

import edu.estu.ovs.core.results.abstracts.ApiDataResult;
import edu.estu.ovs.core.utilities.Msg;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ApiErrorDataResult<T> extends ApiDataResult<T> {

    private final String debugMessage;

    public ApiErrorDataResult(Throwable ex, HttpStatus status, String message, T data) {
        super(status, message, data);
        this.debugMessage = ex.getLocalizedMessage().replaceAll("(%s\s)", "");
    }

    public ApiErrorDataResult(Throwable ex, HttpStatus status, String message) {
        this(ex, status, message, null);
    }

    public ApiErrorDataResult(Throwable ex, HttpStatus status) {
        this(ex, status, Msg.UNEXPECTED_ERROR);
    }

    public ApiErrorDataResult(Throwable ex) {
        this(ex, HttpStatus.BAD_REQUEST);
    }

    public ApiErrorDataResult(Throwable ex, String message, T data) {
        this(ex, HttpStatus.BAD_REQUEST, message, data);
    }

    public ApiErrorDataResult(Throwable ex, String message) {
        this(ex, HttpStatus.BAD_REQUEST, message);
    }

}
