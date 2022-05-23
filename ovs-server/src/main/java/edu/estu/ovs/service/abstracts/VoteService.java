package edu.estu.ovs.service.abstracts;

import edu.estu.ovs.core.results.abstracts.ApiResult;
import edu.estu.ovs.models.dtos.VoteDto;
import org.springframework.stereotype.Service;

@Service
public interface VoteService {
    ApiResult getAll();

    ApiResult getById(Integer voteId);

    ApiResult getByElectionAndVoter(Integer eid, Integer voterId);

    ApiResult getByElection(Integer eid);

    ApiResult getByVoter(Integer voterId);

    ApiResult getByElectionAndCandidate(Integer eid, Integer candId);

    ApiResult vote(VoteDto voteDto);

    ApiResult delete(Integer voteId);
}
