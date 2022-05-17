package edu.estu.ovs.service.abstracts;

import edu.estu.ovs.core.response.results.abstracts.ApiResult;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    ApiResult getAll();

    ApiResult delete(Integer uid);

    ApiResult addPhoneNumber(Integer uid, String phoneNumber);
}
