package edu.estu.ovs.service.concretes;

import edu.estu.ovs.core.results.abstracts.ApiResult;
import edu.estu.ovs.core.results.success.ApiSuccessDataResult;
import edu.estu.ovs.core.utilities.Msg;
import edu.estu.ovs.dataaccess.abstracts.VoterDao;
import edu.estu.ovs.models.dtos.VoterDto;
import edu.estu.ovs.models.entities.Authority;
import edu.estu.ovs.models.entities.Voter;
import edu.estu.ovs.models.enums.RoleName;
import edu.estu.ovs.service.abstracts.VoterService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class VoterManager implements VoterService {

    private final VoterDao voterDao;
    private final ModelMapper modelMapper;

    @Override
    public ApiResult save(VoterDto voterDto) {
        Voter voter = modelMapper.map(voterDto, Voter.class);
        voter.setAuthorities(new ArrayList<>(List.of(new Authority(1, RoleName.ROLE_VOTER))));
        return new ApiSuccessDataResult<>(HttpStatus.CREATED, Msg.SAVED, voterDao.save(voter));
    }

    @Override
    public ApiResult getAll() {
        return new ApiSuccessDataResult<>(voterDao.findAll());
    }

}
