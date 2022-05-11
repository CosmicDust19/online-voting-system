package edu.estu.ovs.business.concretes;

import edu.estu.ovs.business.abstracts.CandidateService;
import edu.estu.ovs.core.utilities.results.DataResult;
import edu.estu.ovs.core.utilities.results.SuccessDataResult;
import edu.estu.ovs.dataAccess.CandidateDao;
import edu.estu.ovs.models.entities.Candidate;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CandidateManager implements CandidateService {

    private final CandidateDao candidateDao;
    private final ModelMapper modelMapper;

    @Override
    public DataResult<List<Candidate>> getAll() {
        return new SuccessDataResult<>(candidateDao.findAll());
    }

}
