package edu.estu.ovs.business.concretes;

import edu.estu.ovs.business.abstracts.ElectionService;
import edu.estu.ovs.core.utilities.results.DataResult;
import edu.estu.ovs.core.utilities.results.SuccessDataResult;
import edu.estu.ovs.dataAccess.ElectionDao;
import edu.estu.ovs.models.entities.Election;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ElectionManager implements ElectionService {

    private final ElectionDao electionDao;
    private final ModelMapper modelMapper;

    @Override
    public DataResult<List<Election>> getAll() {
        return new SuccessDataResult<>(electionDao.findAll());
    }

}
