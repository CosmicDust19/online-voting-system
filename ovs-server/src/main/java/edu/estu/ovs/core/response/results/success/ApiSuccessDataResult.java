package edu.estu.ovs.core.response.results.success;

import edu.estu.ovs.core.response.results.abstracts.ApiDataResult;
import edu.estu.ovs.core.utilities.Msg;
import org.springframework.http.HttpStatus;

public class ApiSuccessDataResult<T> extends ApiDataResult<T> {

    public ApiSuccessDataResult(HttpStatus status, String message, T data) {
        super(status, message, data);
    }

    public ApiSuccessDataResult(HttpStatus status, T data) {
        this(status, Msg.SUCCESS, data);
    }

    public ApiSuccessDataResult(String message, T data) {
        this(HttpStatus.OK, message, data);
    }

    public ApiSuccessDataResult(T data) {
        this(Msg.SUCCESS, data);
    }

}
