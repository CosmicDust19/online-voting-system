package edu.estu.ovs.business.concretes;

import edu.estu.ovs.business.abstracts.UserService;
import edu.estu.ovs.core.utilities.results.DataResult;
import edu.estu.ovs.core.utilities.results.SuccessDataResult;
import edu.estu.ovs.dataAccess.UserDao;
import edu.estu.ovs.models.entities.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserManager implements UserService {

    private final UserDao userDao;
    private final ModelMapper modelMapper;

    @Override
    public DataResult<List<User>> getAll() {
        return new SuccessDataResult<>(userDao.findAll());
    }

}
