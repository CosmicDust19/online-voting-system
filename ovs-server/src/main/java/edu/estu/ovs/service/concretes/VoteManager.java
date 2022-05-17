package edu.estu.ovs.service.concretes;

import edu.estu.ovs.core.response.results.abstracts.ApiResult;
import edu.estu.ovs.core.response.results.success.ApiSuccessDataResult;
import edu.estu.ovs.core.utilities.Msg;
import edu.estu.ovs.data.access.abstracts.VoteDao;
import edu.estu.ovs.models.dtos.VoteDto;
import edu.estu.ovs.models.entities.Vote;
import edu.estu.ovs.service.abstracts.VoteService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VoteManager implements VoteService {

    private final VoteDao voteDao;
    private final ModelMapper modelMapper;

    @Override
    public ApiResult getAll() {
        return new ApiSuccessDataResult<>(voteDao.findAll());
    }

    @Override
    public ApiResult vote(VoteDto voteDto) {
        return new ApiSuccessDataResult<>(Msg.SAVED, voteDao.save(modelMapper.map(voteDto, Vote.class)));
    }

}
