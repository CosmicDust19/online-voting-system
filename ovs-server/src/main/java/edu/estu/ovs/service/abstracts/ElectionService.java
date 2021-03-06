package edu.estu.ovs.service.abstracts;

import edu.estu.ovs.core.results.abstracts.ApiResult;
import edu.estu.ovs.models.dtos.ElectionDto;
import org.springframework.stereotype.Service;

@Service
public interface ElectionService {
    ApiResult getAll();

    ApiResult getById(Integer eid);

    ApiResult getAdminResponsibilities(Integer adminId);

    ApiResult save(ElectionDto electionDto);

    ApiResult addAttender(Integer candId, Integer eid);

    ApiResult addExecutive(Integer adminId, Integer eid);

    ApiResult removeAttender(Integer candId, Integer eid);

    ApiResult removeExecutive(Integer adminId, Integer eid);

    ApiResult delete(Integer eid);
}
