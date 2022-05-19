package edu.estu.ovs.api.controllers;

import edu.estu.ovs.core.response.results.abstracts.ApiResult;
import edu.estu.ovs.core.utilities.Constants;
import edu.estu.ovs.core.utilities.Msg;
import edu.estu.ovs.core.utilities.annotations.PhoneNumber;
import edu.estu.ovs.core.validation.annotations.Exists;
import edu.estu.ovs.core.validation.annotations.NotExists;
import edu.estu.ovs.service.abstracts.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Pattern;

import static edu.estu.ovs.core.utilities.Utils.buildResponseEntity;

@CrossOrigin(origins = {Constants.Origin.LOCALHOST_3000})
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Validated
public class UserController {

    private final UserService userService;

    @GetMapping("/get/all")
    public ResponseEntity<ApiResult> getAll() {
        return buildResponseEntity(userService.getAll());
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ApiResult> delete(@Exists(column = "uid", table = "user") @RequestParam Integer uid) {
        return buildResponseEntity(userService.delete(uid));
    }

    @PatchMapping("/patch/phone_number/add")
    public ResponseEntity<ApiResult> addPhoneNumber(
            @Exists(column = "uid", table = "user") @RequestParam Integer uid,
            @Pattern(regexp = Constants.RegExp.PHONE_NUM, message = Msg.PATTERN)
            @NotExists(column = "phone_number", table = "user_phone_numbers")
            @PhoneNumber @RequestParam String phoneNumber) {
        return buildResponseEntity(userService.addPhoneNumber(uid, phoneNumber));
    }

    @PatchMapping("/patch/phone_number/remove")
    public ResponseEntity<ApiResult> removePhoneNumber(
            @Exists(column = "uid", table = "user") @RequestParam Integer uid,
            @Exists(column = "phone_number", table = "user_phone_numbers")
            @PhoneNumber @RequestParam String phoneNumber) {
        return buildResponseEntity(userService.removePhoneNumber(uid, phoneNumber));
    }

}
