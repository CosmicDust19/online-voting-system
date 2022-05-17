package edu.estu.ovs.api.controllers;

import edu.estu.ovs.core.response.results.abstracts.ApiResult;
import edu.estu.ovs.core.utilities.Constants;
import edu.estu.ovs.core.validation.groups.OnCreate;
import edu.estu.ovs.models.dtos.VoteDto;
import edu.estu.ovs.service.abstracts.VoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static edu.estu.ovs.core.utilities.Utils.buildResponseEntity;

@CrossOrigin(origins = {Constants.Origin.LOCALHOST_3000})
@RestController
@RequestMapping("/vote")
@RequiredArgsConstructor
@Validated
public class VoteController {

    private final VoteService voteService;

    @GetMapping("/get/all")
    public ResponseEntity<ApiResult> getAll() {
        return buildResponseEntity(voteService.getAll());
    }

    @PostMapping("/vote")
    public ResponseEntity<ApiResult> vote(@Validated(OnCreate.class) @RequestBody VoteDto voteDto) {
        return buildResponseEntity(voteService.vote(voteDto));
    }
}
