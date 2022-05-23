package edu.estu.ovs.service.abstracts;

import edu.estu.ovs.core.results.abstracts.ApiResult;
import edu.estu.ovs.models.dtos.CandidateDto;
import edu.estu.ovs.models.dtos.CertificationDto;
import edu.estu.ovs.models.dtos.SchoolDto;
import org.springframework.stereotype.Service;

@Service
public interface CandidateService {
    ApiResult getAll();

    ApiResult save(CandidateDto candidateDto);

    ApiResult saveCertification(CertificationDto certDto);

    ApiResult removeCertification(Integer certId);

    ApiResult saveSchool(SchoolDto schDto);

    ApiResult removeSchool(Integer schId);
}
