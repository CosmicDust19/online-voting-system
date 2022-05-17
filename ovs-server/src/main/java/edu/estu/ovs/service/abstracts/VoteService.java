package edu.estu.ovs.service.abstracts;

import edu.estu.ovs.core.response.results.abstracts.ApiResult;
import edu.estu.ovs.models.dtos.VoteDto;
import org.springframework.stereotype.Service;

@Service
public interface VoteService {
    ApiResult getAll();

    ApiResult vote(VoteDto voteDto);
}
