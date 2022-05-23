package edu.estu.ovs.api.controllers;

import edu.estu.ovs.core.results.error.ApiErrorResult;
import io.swagger.annotations.Api;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@RestController
@Api(tags = "Main")
public class MainController implements ErrorController {

    @RequestMapping("/")
    public void redirectToSwaggerUI(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui/index.html#");
    }

    @RequestMapping("/error")
    public ResponseEntity<ApiErrorResult> handleError(HttpServletRequest request) {
        HttpStatus httpStatus = Optional
                .of(request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE))
                .flatMap(sub -> Optional.of(sub.toString()))
                .flatMap(sub -> Optional.of(Integer.parseInt(sub)))
                .map(HttpStatus::resolve)
                .orElse(HttpStatus.BAD_REQUEST);
        return ResponseEntity.status(httpStatus).body(new ApiErrorResult(httpStatus));
    }

}
