package edu.estu.ovs.service.abstracts;

import edu.estu.ovs.core.results.abstracts.ApiResult;
import edu.estu.ovs.models.entities.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService {

    Optional<User> findByUserName(String email);

    ApiResult getAll();

    ApiResult delete(String email);

    ApiResult updateEnabled(Integer uid, Boolean status);

    ApiResult addPhoneNumber(Integer uid, String phoneNumber);

    ApiResult removePhoneNumber(Integer uid, String phoneNumber);

}
