package edu.estu.ovs.business.concretes;

import edu.estu.ovs.business.abstracts.VoterService;
import edu.estu.ovs.core.utilities.results.DataResult;
import edu.estu.ovs.core.utilities.results.SuccessDataResult;
import edu.estu.ovs.dataAccess.VoterDao;
import edu.estu.ovs.models.entities.Voter;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VoterManager implements VoterService {

    private final VoterDao voterDao;
    private final ModelMapper modelMapper;

    @Override
    public DataResult<List<Voter>> getAll() {
        return new SuccessDataResult<>(voterDao.findAll());
    }

}
