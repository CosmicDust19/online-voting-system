package edu.estu.ovs.business.abstracts;

import edu.estu.ovs.core.utilities.results.DataResult;
import edu.estu.ovs.models.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    DataResult<List<User>> getAll();
}
