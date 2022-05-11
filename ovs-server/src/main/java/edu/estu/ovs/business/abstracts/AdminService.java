package edu.estu.ovs.business.abstracts;

import edu.estu.ovs.core.utilities.results.DataResult;
import edu.estu.ovs.core.utilities.results.Result;
import edu.estu.ovs.models.dtos.UserCrDto;
import edu.estu.ovs.models.entities.Admin;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminService {
    DataResult<List<Admin>> getAll();

    Result add(UserCrDto userCrDto);
}
