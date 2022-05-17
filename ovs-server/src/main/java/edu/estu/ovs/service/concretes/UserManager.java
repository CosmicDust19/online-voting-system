package edu.estu.ovs.service.concretes;

import edu.estu.ovs.core.response.results.abstracts.ApiResult;
import edu.estu.ovs.core.response.results.success.ApiSuccessDataResult;
import edu.estu.ovs.core.response.results.success.ApiSuccessResult;
import edu.estu.ovs.core.utilities.Msg;
import edu.estu.ovs.core.utilities.Utils;
import edu.estu.ovs.data.access.abstracts.UserDao;
import edu.estu.ovs.models.entities.User;
import edu.estu.ovs.service.abstracts.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserManager implements UserService {

    private final UserDao userDao;

    @Override
    public ApiResult getAll() {
        return new ApiSuccessDataResult<>(userDao.findAll());
    }

    @Override
    public ApiResult delete(Integer uid) {
        userDao.deleteById(uid);
        return new ApiSuccessResult(Msg.DELETED);
    }

    @Override
    public ApiResult addPhoneNumber(Integer uid, String phoneNumber) {
        User user = userDao.findById(uid).orElseThrow(EntityNotFoundException::new);
        user.getPhoneNumbers().add(Utils.getFormattedPhoneNumber(phoneNumber));
        return new ApiSuccessDataResult<>(Msg.SAVED, userDao.save(user));
    }
}
