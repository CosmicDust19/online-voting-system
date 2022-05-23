package edu.estu.ovs.core.results.abstracts;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public abstract class ApiDataResult<DataType> extends ApiResult {

    private final DataType data;

    public ApiDataResult(HttpStatus status, DataType data) {
        super(status);
        this.data = data;
    }

    public ApiDataResult(HttpStatus status, String message, DataType data) {
        super(status, message);
        this.data = data;
    }

}
