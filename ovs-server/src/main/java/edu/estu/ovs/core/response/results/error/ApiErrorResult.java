package edu.estu.ovs.core.response.results.error;

import edu.estu.ovs.core.response.results.abstracts.ApiDataResult;
import edu.estu.ovs.core.response.results.abstracts.ApiResult;
import edu.estu.ovs.core.response.results.abstracts.ApiSubError;
import edu.estu.ovs.core.utilities.Msg;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
public class ApiErrorResult<T> extends ApiDataResult<T> {

    private final String debugMessage;

    public ApiErrorResult(Throwable ex, HttpStatus status, String message, T data) {
        super(status, message, data);
        this.debugMessage = ex.getLocalizedMessage().replaceAll("(%s\s)", "");
    }

    public ApiErrorResult(Throwable ex, HttpStatus status, String message) {
        this(ex, status, message, null);
    }

    public ApiErrorResult(Throwable ex, HttpStatus status) {
        this(ex, status, Msg.UNEXPECTED_ERROR);
    }

    public ApiErrorResult(Throwable ex) {
        this(ex, HttpStatus.BAD_REQUEST);
    }

    public ApiErrorResult(Throwable ex, String message, T data) {
        this(ex, HttpStatus.BAD_REQUEST, message, data);
    }

    public ApiErrorResult(Throwable ex, String message) {
        this(ex, HttpStatus.BAD_REQUEST, message);
    }

}
