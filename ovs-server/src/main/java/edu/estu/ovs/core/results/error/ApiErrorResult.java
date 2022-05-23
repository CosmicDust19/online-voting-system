package edu.estu.ovs.core.results.error;

import edu.estu.ovs.core.results.abstracts.ApiResult;
import edu.estu.ovs.core.utilities.Msg;
import org.springframework.http.HttpStatus;

public class ApiErrorResult extends ApiResult {

    public ApiErrorResult(HttpStatus status, String message) {
        super(status, message);
    }

    public ApiErrorResult(HttpStatus status) {
        this(status, Msg.ERROR);
    }

    public ApiErrorResult(String message) {
        this(HttpStatus.BAD_REQUEST, message);
    }

    public ApiErrorResult() {
        this(Msg.ERROR);
    }

}
