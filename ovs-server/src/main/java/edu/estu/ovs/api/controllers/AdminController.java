package edu.estu.ovs.api.controllers;

import edu.estu.ovs.core.response.results.abstracts.ApiResult;
import edu.estu.ovs.core.utilities.Constants;
import edu.estu.ovs.core.validation.annotations.Exists;
import edu.estu.ovs.core.validation.groups.OnCreate;
import edu.estu.ovs.core.validation.groups.OnUpdate;
import edu.estu.ovs.models.dtos.AdminDto;
import edu.estu.ovs.service.abstracts.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static edu.estu.ovs.core.utilities.Utils.buildResponseEntity;

@CrossOrigin(origins = {Constants.Origin.LOCALHOST_3000})
@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
@Validated
public class AdminController {

    private final AdminService adminService;

    @GetMapping("/get/all")
    public ResponseEntity<ApiResult> getAll() {
        return buildResponseEntity(adminService.getAll());
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResult> create(@Validated(OnCreate.class) @RequestBody AdminDto adminDto) {
        return buildResponseEntity(adminService.save(adminDto));
    }

    @PutMapping("/update")
    public ResponseEntity<ApiResult> update(@Validated(OnUpdate.class) @RequestBody AdminDto adminDto) {
        return buildResponseEntity(adminService.save(adminDto));
    }

    @PatchMapping("/patch/verified")
    public ResponseEntity<ApiResult> updateVerification(
            @Exists(column = "uid", table = "admin") @RequestParam Integer uid, @RequestParam Boolean status) {
        return buildResponseEntity(adminService.updateVerification(uid, status));
    }

}
