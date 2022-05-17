package edu.estu.ovs.core.response.results.success;

import edu.estu.ovs.core.response.results.abstracts.ApiResult;
import edu.estu.ovs.core.utilities.Msg;
import org.springframework.http.HttpStatus;

public class ApiSuccessResult extends ApiResult {

    public ApiSuccessResult(HttpStatus status, String message) {
        super(status, message);
    }

    public ApiSuccessResult(HttpStatus status) {
        this(status, Msg.SUCCESS);
    }

    public ApiSuccessResult(String message) {
        this(HttpStatus.OK, message);
    }

    public ApiSuccessResult() {
        this(Msg.SUCCESS);
    }

}
