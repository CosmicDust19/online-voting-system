package edu.estu.ovs.api.controllers;

import edu.estu.ovs.core.results.abstracts.ApiResult;
import edu.estu.ovs.core.utilities.Constants;
import edu.estu.ovs.core.validation.annotations.Exists;
import edu.estu.ovs.core.validation.groups.OnCreate;
import edu.estu.ovs.core.validation.groups.OnUpdate;
import edu.estu.ovs.models.dtos.ElectionDto;
import edu.estu.ovs.service.abstracts.ElectionService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static edu.estu.ovs.core.utilities.Utils.buildResponseEntity;

@CrossOrigin(origins = {Constants.Origin.LOCALHOST_3000})
@RestController
@RequestMapping("/election")
@RequiredArgsConstructor
@Validated
@Api(tags = "Election")
public class ElectionController {

    private final ElectionService electionService;

    @GetMapping("/get/all")
    public ResponseEntity<ApiResult> getAll() {
        return buildResponseEntity(electionService.getAll());
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResult> create(@Validated(OnCreate.class) @RequestBody ElectionDto electionDto) {
        return buildResponseEntity(electionService.save(electionDto));
    }

    @PutMapping("/update")
    public ResponseEntity<ApiResult> update(@Validated(OnUpdate.class) @RequestBody ElectionDto electionDto) {
        return buildResponseEntity(electionService.save(electionDto));
    }

    @PatchMapping("/patch/executives/add")
    public ResponseEntity<ApiResult> addExecutive(
            @Exists(column = "uid", table = "admin") @RequestParam Integer adminId,
            @Exists(column = "eid", table = "election") @RequestParam Integer eid) {
        return buildResponseEntity(electionService.addExecutive(adminId, eid));
    }

    @PatchMapping("/patch/executives/remove")
    public ResponseEntity<ApiResult> removeExecutive(
            @Exists(column = "uid", table = "admin") @RequestParam Integer adminId,
            @Exists(column = "eid", table = "election") @RequestParam Integer eid) {
        return buildResponseEntity(electionService.removeExecutive(adminId, eid));
    }

    @PatchMapping("/patch/attender/add")
    public ResponseEntity<ApiResult> addAttender(
            @Exists(column = "uid", table = "candidate") @RequestParam Integer candId,
            @Exists(column = "eid", table = "election") @RequestParam Integer eid) {
        return buildResponseEntity(electionService.addAttender(candId, eid));
    }

    @PatchMapping("/patch/attender/remove")
    public ResponseEntity<ApiResult> removeAttender(
            @Exists(column = "uid", table = "candidate") @RequestParam Integer candId,
            @Exists(column = "eid", table = "election") @RequestParam Integer eid) {
        return buildResponseEntity(electionService.removeAttender(candId, eid));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ApiResult> delete(@Exists(column = "eid", table = "election") @RequestParam Integer eid) {
        return buildResponseEntity(electionService.delete(eid));
    }
}
