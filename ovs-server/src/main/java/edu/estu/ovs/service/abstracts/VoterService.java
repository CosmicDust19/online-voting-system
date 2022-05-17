package edu.estu.ovs.service.abstracts;

import edu.estu.ovs.core.response.results.abstracts.ApiResult;
import edu.estu.ovs.models.dtos.UserDto;
import org.springframework.stereotype.Service;

@Service
public interface VoterService {
    ApiResult getAll();

    ApiResult save(UserDto userDto);
}
