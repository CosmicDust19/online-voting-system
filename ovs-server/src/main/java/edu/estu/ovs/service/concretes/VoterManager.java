package edu.estu.ovs.service.concretes;

import edu.estu.ovs.core.response.results.abstracts.ApiResult;
import edu.estu.ovs.core.response.results.success.ApiSuccessDataResult;
import edu.estu.ovs.core.utilities.Msg;
import edu.estu.ovs.data.access.abstracts.VoterDao;
import edu.estu.ovs.models.dtos.VoterDto;
import edu.estu.ovs.models.entities.Voter;
import edu.estu.ovs.service.abstracts.VoterService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VoterManager implements VoterService {

    private final VoterDao voterDao;
    private final ModelMapper modelMapper;

    @Override
    public ApiResult save(VoterDto voterDto) {
        return new ApiSuccessDataResult<>(Msg.SAVED, voterDao.save(modelMapper.map(voterDto, Voter.class)));
    }

    @Override
    public ApiResult getAll() {
        return new ApiSuccessDataResult<>(voterDao.findAll());
    }

}
