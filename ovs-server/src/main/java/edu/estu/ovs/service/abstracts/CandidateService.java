package edu.estu.ovs.service.abstracts;

import edu.estu.ovs.core.response.results.abstracts.ApiResult;
import edu.estu.ovs.models.dtos.CandidateDto;
import edu.estu.ovs.models.dtos.CertificationDto;
import edu.estu.ovs.models.dtos.SchoolDto;
import org.springframework.stereotype.Service;

@Service
public interface CandidateService {
    ApiResult getAll();

    ApiResult save(CandidateDto candidateDto);

    ApiResult updateVerification(Integer uid, Boolean status);

    ApiResult saveCertification(CertificationDto certDto);

    ApiResult saveSchool(SchoolDto schDto);

}
