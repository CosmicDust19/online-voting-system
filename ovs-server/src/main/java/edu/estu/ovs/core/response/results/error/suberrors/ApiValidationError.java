package edu.estu.ovs.core.response.results.error.suberrors;

import com.fasterxml.jackson.annotation.JsonFormat;
import edu.estu.ovs.core.response.results.abstracts.ApiSubError;
import edu.estu.ovs.core.utilities.Msg;

import lombok.Getter;

import javax.validation.Path;

@Getter
public class ApiValidationError extends ApiSubError {

    private final String object;
    private final String field;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private final Object rejectedValue;
    private final String message;

    public ApiValidationError(String object, String message) {
        this.object = object;
        this.field = null;
        this.rejectedValue = null;
        this.message = message;
    }

    public ApiValidationError(String object, String field, Object rejectedValue, String message) {
        this.object = object;
        this.field = field;
        this.rejectedValue = rejectedValue;
        this.message = field == null ? message : Msg.getViolationMsg(field, message);
    }

    public ApiValidationError(Path propPath, Object rejectedValue, String message) {
        String[] sliced = propPath.toString().split("\\.");
        String object = sliced[sliced.length - 2];
        String field = sliced[sliced.length - 1];
        this.object = object;
        this.field = field;
        this.rejectedValue = rejectedValue;
        this.message = field == null ? message : Msg.getViolationMsg(field, message);
    }
}
