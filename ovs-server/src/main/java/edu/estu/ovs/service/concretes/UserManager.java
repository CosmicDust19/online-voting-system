package edu.estu.ovs.service.concretes;

import edu.estu.ovs.core.response.results.abstracts.ApiResult;
import edu.estu.ovs.core.response.results.success.ApiSuccessDataResult;
import edu.estu.ovs.core.response.results.success.ApiSuccessResult;
import edu.estu.ovs.core.utilities.Msg;
import edu.estu.ovs.core.utilities.Utils;
import edu.estu.ovs.core.utilities.annotations.PhoneNumber;
import edu.estu.ovs.data.access.abstracts.UserDao;
import edu.estu.ovs.models.entities.User;
import edu.estu.ovs.service.abstracts.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.*;

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
        user.getPhoneNumbers().add(phoneNumber);
        return new ApiSuccessDataResult<>(Msg.SAVED, userDao.save(user));
    }

    @Override
    public ApiResult removePhoneNumber(Integer uid, String phoneNumber) {
        User user = userDao.findById(uid).orElseThrow(EntityNotFoundException::new);
        user.getPhoneNumbers().removeIf(phoneNumberIter -> Objects.equals(phoneNumberIter, phoneNumber));
        return new ApiSuccessDataResult<>(Msg.SAVED, userDao.save(user));
    }

}
