package edu.estu.ovs.service.abstracts;

import edu.estu.ovs.core.response.results.abstracts.ApiResult;
import edu.estu.ovs.models.dtos.AdminDto;
import org.springframework.stereotype.Service;

@Service
public interface AdminService {
    ApiResult getAll();

    ApiResult save(AdminDto adminDto);

    ApiResult updateVerification(Integer uid, Boolean status);
}
