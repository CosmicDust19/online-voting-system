package edu.estu.ovs.service.concretes;

import edu.estu.ovs.core.results.abstracts.ApiResult;
import edu.estu.ovs.core.results.success.ApiSuccessDataResult;
import edu.estu.ovs.core.results.success.ApiSuccessResult;
import edu.estu.ovs.core.utilities.Msg;
import edu.estu.ovs.dataaccess.abstracts.ElectionDao;
import edu.estu.ovs.dataaccess.abstracts.VoteDao;
import edu.estu.ovs.models.dtos.VoteDto;
import edu.estu.ovs.models.entities.Candidate;
import edu.estu.ovs.models.entities.Election;
import edu.estu.ovs.models.entities.Vote;
import edu.estu.ovs.service.abstracts.VoteService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class VoteManager implements VoteService {

    private final VoteDao voteDao;
    private final ElectionDao electionDao;
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
    public ApiResult getVoteCountByElectionAndCandidate(Integer eid, Integer candId) {
        return new ApiSuccessDataResult<>(voteDao.countByElection_EidAndCandidate_Uid(eid, candId));
    }

    @Override
    public ApiResult getVoteCountsByElection(Integer eid) {
        Election election = electionDao.findById(eid).orElseThrow(EntityNotFoundException::new);
        Map<Integer, Integer> candVoteMap = election.getAttenders().stream()
                .collect(Collectors.toMap(Candidate::getUid, cand -> voteDao.countByElection_EidAndCandidate_Uid(eid, cand.getUid())));
        return new ApiSuccessDataResult<>(candVoteMap);
    }

    @Override
    public ApiResult cast(VoteDto voteDto) {
        return new ApiSuccessDataResult<>(HttpStatus.CREATED, Msg.SAVED, voteDao.save(modelMapper.map(voteDto, Vote.class)));
    }

    @Override
    public ApiResult delete(Integer voteId) {
        voteDao.deleteById(voteId);
        return new ApiSuccessResult(Msg.DELETED);
    }

}
