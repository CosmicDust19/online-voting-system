package edu.estu.ovs.api.controllers;

import edu.estu.ovs.core.response.results.abstracts.ApiResult;
import edu.estu.ovs.core.utilities.Constants;
import edu.estu.ovs.core.validation.groups.OnCreate;
import edu.estu.ovs.models.dtos.UserDto;
import edu.estu.ovs.service.abstracts.VoterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static edu.estu.ovs.core.utilities.Utils.buildResponseEntity;

@CrossOrigin(origins = {Constants.Origin.LOCALHOST_3000})
@RestController
@RequestMapping("/voter")
@RequiredArgsConstructor
@Validated
public class VoterController {

    private final VoterService voterService;

    @GetMapping("/get/all")
    public ResponseEntity<ApiResult> getAll() {
        return buildResponseEntity(voterService.getAll());
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResult> create(@Validated(OnCreate.class) @RequestBody UserDto userDto) {
        return buildResponseEntity(voterService.save(userDto));
    }

}
