package edu.estu.ovs.service.concretes;

import edu.estu.ovs.core.results.abstracts.ApiResult;
import edu.estu.ovs.core.results.success.ApiSuccessDataResult;
import edu.estu.ovs.core.results.success.ApiSuccessResult;
import edu.estu.ovs.core.utilities.Msg;
import edu.estu.ovs.dataaccess.abstracts.AdminDao;
import edu.estu.ovs.dataaccess.abstracts.CandidateDao;
import edu.estu.ovs.dataaccess.abstracts.ElectionDao;
import edu.estu.ovs.models.dtos.ElectionDto;
import edu.estu.ovs.models.entities.Election;
import edu.estu.ovs.service.abstracts.ElectionService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.Objects;

@Service
@Transactional
@RequiredArgsConstructor
public class ElectionManager implements ElectionService {

    private final ElectionDao electionDao;
    private final CandidateDao candidateDao;
    private final AdminDao adminDao;
    private final ModelMapper modelMapper;

    @Override
    public ApiResult getAll() {
        return new ApiSuccessDataResult<>(electionDao.findAll());
    }

    @Override
    public ApiResult save(ElectionDto electionDto) {
        return new ApiSuccessDataResult<>(HttpStatus.CREATED, Msg.SAVED, electionDao.save(modelMapper.map(electionDto, Election.class)));
    }

    @Override
    public ApiResult addAttender(Integer candId, Integer eid) {
        Election election = electionDao.findById(eid).orElseThrow(EntityNotFoundException::new);
        election.getAttenders().add(candidateDao.findById(candId).orElseThrow(EntityNotFoundException::new));
        return new ApiSuccessDataResult<>(Msg.SAVED, electionDao.save(election));
    }

    @Override
    public ApiResult addExecutive(Integer adminId, Integer eid) {
        Election election = electionDao.findById(eid).orElseThrow(EntityNotFoundException::new);
        election.getExecutives().add(adminDao.findById(adminId).orElseThrow(EntityNotFoundException::new));
        return new ApiSuccessDataResult<>(Msg.SAVED, electionDao.save(election));
    }

    @Override
    public ApiResult removeAttender(Integer candId, Integer eid) {
        Election election = electionDao.findById(eid).orElseThrow(EntityNotFoundException::new);
        election.getAttenders().removeIf(attender -> Objects.equals(attender.getUid(), candId));
        return new ApiSuccessDataResult<>(Msg.REMOVED, electionDao.save(election));
    }

    @Override
    public ApiResult removeExecutive(Integer adminId, Integer eid) {
        Election election = electionDao.findById(eid).orElseThrow(EntityNotFoundException::new);
        election.getExecutives().removeIf(executive -> Objects.equals(executive.getUid(), adminId));
        return new ApiSuccessDataResult<>(Msg.REMOVED, electionDao.save(election));
    }

    @Override
    public ApiResult delete(Integer eid) {
        electionDao.deleteById(eid);
        return new ApiSuccessResult(Msg.DELETED);
    }

}
