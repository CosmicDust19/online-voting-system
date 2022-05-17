package edu.estu.ovs.service.concretes;

import edu.estu.ovs.core.response.results.abstracts.ApiResult;
import edu.estu.ovs.core.response.results.success.ApiSuccessDataResult;
import edu.estu.ovs.core.response.results.success.ApiSuccessResult;
import edu.estu.ovs.core.utilities.Msg;
import edu.estu.ovs.data.access.abstracts.ElectionDao;
import edu.estu.ovs.models.dtos.ElectionDto;
import edu.estu.ovs.models.entities.Election;
import edu.estu.ovs.service.abstracts.ElectionService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ElectionManager implements ElectionService {

    private final ElectionDao electionDao;
    private final ModelMapper modelMapper;

    @Override
    public ApiResult save(ElectionDto electionDto) {
        return new ApiSuccessDataResult<>(Msg.SAVED, electionDao.save(modelMapper.map(electionDto, Election.class)));
    }

    @Override
    public ApiResult getAll() {
        return new ApiSuccessDataResult<>(electionDao.findAll());
    }

    @Override
    public ApiResult delete(Integer eid) {
        electionDao.deleteById(eid);
        return new ApiSuccessResult(Msg.DELETED);
    }

}
