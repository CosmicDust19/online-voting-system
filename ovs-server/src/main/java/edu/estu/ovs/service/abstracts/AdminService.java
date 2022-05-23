package edu.estu.ovs.service.abstracts;

import edu.estu.ovs.core.results.abstracts.ApiResult;
import edu.estu.ovs.models.dtos.AdminDto;
import org.springframework.stereotype.Service;

@Service
public interface AdminService {
    ApiResult getAll();

    ApiResult save(AdminDto adminDto);

}
