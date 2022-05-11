package edu.estu.ovs.business.concretes;

import edu.estu.ovs.business.abstracts.VoteService;
import edu.estu.ovs.core.utilities.results.DataResult;
import edu.estu.ovs.core.utilities.results.SuccessDataResult;
import edu.estu.ovs.dataAccess.VoteDao;
import edu.estu.ovs.models.entities.Vote;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VoteManager implements VoteService {

    private final VoteDao voteDao;
    private final ModelMapper modelMapper;

    @Override
    public DataResult<List<Vote>> getAll() {
        return new SuccessDataResult<>(voteDao.findAll());
    }

}
