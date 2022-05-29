package edu.estu.ovs.api.controllers;

import edu.estu.ovs.core.results.abstracts.ApiResult;
import edu.estu.ovs.core.utilities.Constants;
import edu.estu.ovs.core.validation.annotations.Exists;
import edu.estu.ovs.core.validation.groups.OnCreate;
import edu.estu.ovs.models.dtos.VoteDto;
import edu.estu.ovs.service.abstracts.VoteService;
import io.swagger.annotations.Api;
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
@Api(tags = "Vote")
public class VoteController {

    private final VoteService voteService;

    @GetMapping("/get/all")
    public ResponseEntity<ApiResult> getAll() {
        return buildResponseEntity(voteService.getAll());
    }

    @GetMapping("/get/id")
    public ResponseEntity<ApiResult> getById(@RequestParam Integer voteId) {
        return buildResponseEntity(voteService.getById(voteId));
    }

    @GetMapping("/get/voter")
    public ResponseEntity<ApiResult> getByVoter(@RequestParam Integer voterId) {
        return buildResponseEntity(voteService.getByVoter(voterId));
    }

    @GetMapping("/get/election")
    public ResponseEntity<ApiResult> getByElection(@RequestParam Integer eid) {
        return buildResponseEntity(voteService.getByElection(eid));
    }

    @GetMapping("/get/election_candidate")
    public ResponseEntity<ApiResult> getByElectionAndCandidate(@RequestParam @Exists(column = "eid", table = "election") Integer eid,
                                                               @RequestParam @Exists(column = "uid", table = "candidate") Integer candId) {
        return buildResponseEntity(voteService.getByElectionAndCandidate(eid, candId));
    }

    @GetMapping("/get/election_voter")
    public ResponseEntity<ApiResult> getByElectionAndVoter(@RequestParam @Exists(column = "eid", table = "election") Integer eid,
                                                           @RequestParam @Exists(column = "uid", table = "voter") Integer voterId) {
        return buildResponseEntity(voteService.getByElectionAndVoter(eid, voterId));
    }

    @GetMapping("/get/vote_count/election_candidate")
    public ResponseEntity<ApiResult> getVoteCountByElectionAndCandidate(@RequestParam @Exists(column = "eid", table = "election") Integer eid,
                                                                        @RequestParam @Exists(column = "uid", table = "candidate") Integer candId) {
        return buildResponseEntity(voteService.getVoteCountByElectionAndCandidate(eid, candId));
    }

    @GetMapping("/get/vote_counts/election")
    public ResponseEntity<ApiResult> getVoteCountsByElection(@RequestParam @Exists(column = "eid", table = "election") Integer eid) {
        return buildResponseEntity(voteService.getVoteCountsByElection(eid));
    }

    @PostMapping("/cast")
    public ResponseEntity<ApiResult> cast(@Validated(OnCreate.class) @RequestBody VoteDto voteDto) {
        return buildResponseEntity(voteService.cast(voteDto));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ApiResult> delete(@Exists(column = "vote_id", table = "vote") @RequestParam Integer voteId) {
        return buildResponseEntity(voteService.delete(voteId));
    }
}
