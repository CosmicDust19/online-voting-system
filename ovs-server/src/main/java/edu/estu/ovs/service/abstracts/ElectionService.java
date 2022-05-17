package edu.estu.ovs.service.abstracts;

import edu.estu.ovs.core.response.results.abstracts.ApiResult;
import edu.estu.ovs.models.dtos.ElectionDto;
import org.springframework.stereotype.Service;

@Service
public interface ElectionService {
    ApiResult getAll();

    ApiResult save(ElectionDto electionDto);

    ApiResult delete(Integer eid);
}
