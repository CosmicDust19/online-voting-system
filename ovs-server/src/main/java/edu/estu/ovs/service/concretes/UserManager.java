package edu.estu.ovs.service.concretes;

import edu.estu.ovs.core.results.abstracts.ApiResult;
import edu.estu.ovs.core.results.success.ApiSuccessDataResult;
import edu.estu.ovs.core.results.success.ApiSuccessResult;
import edu.estu.ovs.core.utilities.Msg;
import edu.estu.ovs.dataaccess.abstracts.UserDao;
import edu.estu.ovs.models.entities.User;
import edu.estu.ovs.service.abstracts.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserManager implements UserService, UserDetailsService {

    private final UserDao userDao;

    @Override
    public Optional<User> findByUserName(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    public ApiResult getAll() {
        return new ApiSuccessDataResult<>(userDao.findAll());
    }

    @Override
    public ApiResult delete(String email) {
        userDao.deleteByEmail(email);
        return new ApiSuccessResult(Msg.DELETED);
    }

    @Override
    public ApiResult updateEnabled(Integer uid, Boolean status) {
        User user = userDao.findById(uid).orElseThrow(EntityNotFoundException::new);
        user.setEnabled(status);
        return new ApiSuccessDataResult<>(userDao.save(user));
    }

    @Override
    public ApiResult addPhoneNumber(Integer uid, String phoneNumber) {
        User user = userDao.findById(uid).orElseThrow(EntityNotFoundException::new);
        user.getPhoneNumbers().add(phoneNumber);
        return new ApiSuccessDataResult<>(HttpStatus.CREATED, Msg.SAVED, userDao.save(user));
    }

    @Override
    public ApiResult removePhoneNumber(Integer uid, String phoneNumber) {
        User user = userDao.findById(uid).orElseThrow(EntityNotFoundException::new);
        user.getPhoneNumbers().removeIf(phoneNumberIter -> Objects.equals(phoneNumberIter, phoneNumber));
        return new ApiSuccessDataResult<>(Msg.SAVED, userDao.save(user));
    }

    @Override
    public UserDetails loadUserByUsername(String email) {
        User user = findByUserName(email).orElseThrow(() -> new UsernameNotFoundException(Msg.INVALID_LOGIN));
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), user.getEnabled(), true, true, true, user.getGrantedAuthorities());
    }

}
