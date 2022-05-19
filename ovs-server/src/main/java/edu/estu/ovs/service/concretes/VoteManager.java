package edu.estu.ovs.service.concretes;

import edu.estu.ovs.core.response.results.abstracts.ApiResult;
import edu.estu.ovs.core.response.results.success.ApiSuccessDataResult;
import edu.estu.ovs.core.response.results.success.ApiSuccessResult;
import edu.estu.ovs.core.utilities.Msg;
import edu.estu.ovs.data.access.abstracts.VoteDao;
import edu.estu.ovs.models.dtos.VoteDto;
import edu.estu.ovs.models.entities.Vote;
import edu.estu.ovs.service.abstracts.VoteService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;

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
    public ApiResult getById(Integer voteId) {
        return new ApiSuccessDataResult<>(voteDao.findById(voteId).orElseThrow(EntityExistsException::new));
    }

    @Override
    public ApiResult getByElection(Integer eid) {
        return new ApiSuccessDataResult<>(voteDao.getByElection_Eid(eid));
    }

    @Override
    public ApiResult getByVoter(Integer voterId) {
        return new ApiSuccessDataResult<>(voteDao.getByVoter_Uid(voterId));
    }

    @Override
    public ApiResult getByElectionAndVoter(Integer eid, Integer voterId) {
        return new ApiSuccessDataResult<>(voteDao.findFirstByElection_EidAndVoter_Uid(eid, voterId));
    }

    @Override
    public ApiResult getByElectionAndCandidate(Integer eid, Integer candId) {
        return new ApiSuccessDataResult<>(voteDao.getByElection_EidAndCandidate_Uid(eid, candId));
    }

    @Override
    public ApiResult vote(VoteDto voteDto) {
        return new ApiSuccessDataResult<>(Msg.SAVED, voteDao.save(modelMapper.map(voteDto, Vote.class)));
    }

    @Override
    public ApiResult delete(Integer voteId) {
        voteDao.deleteById(voteId);
        return new ApiSuccessResult(Msg.DELETED);
    }

}
