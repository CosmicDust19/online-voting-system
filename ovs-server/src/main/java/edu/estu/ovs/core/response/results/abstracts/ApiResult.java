package edu.estu.ovs.core.response.results.abstracts;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
public abstract class ApiResult {

    private HttpStatus status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private final LocalDateTime timestamp;
    private String message;

    private ApiResult() {
        this.timestamp = LocalDateTime.now();
    }

    public ApiResult(HttpStatus status) {
        this();
        this.status = status;
    }

    public ApiResult(HttpStatus status, String message) {
        this(status);
        this.message = message;
    }

}
