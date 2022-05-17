package edu.estu.ovs.api.controllers;

import edu.estu.ovs.core.response.results.abstracts.ApiResult;
import edu.estu.ovs.core.utilities.Constants;
import edu.estu.ovs.core.validation.annotations.Exists;
import edu.estu.ovs.core.validation.groups.OnCreate;
import edu.estu.ovs.models.dtos.ElectionDto;
import edu.estu.ovs.service.abstracts.ElectionService;
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

    @DeleteMapping("/delete")
    public ResponseEntity<ApiResult> delete(@Exists(column = "eid", table = "election") @RequestParam Integer eid) {
        return buildResponseEntity(electionService.delete(eid));
    }
}
