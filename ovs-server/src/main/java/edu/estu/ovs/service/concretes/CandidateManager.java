package edu.estu.ovs.service.concretes;

import edu.estu.ovs.core.response.results.abstracts.ApiResult;
import edu.estu.ovs.core.response.results.success.ApiSuccessDataResult;
import edu.estu.ovs.core.response.results.success.ApiSuccessResult;
import edu.estu.ovs.core.utilities.Msg;
import edu.estu.ovs.data.access.abstracts.CandidateDao;
import edu.estu.ovs.data.access.abstracts.CertificationDao;
import edu.estu.ovs.data.access.abstracts.SchoolDao;
import edu.estu.ovs.models.dtos.CandidateDto;
import edu.estu.ovs.models.dtos.CertificationDto;
import edu.estu.ovs.models.dtos.SchoolDto;
import edu.estu.ovs.models.entities.Candidate;
import edu.estu.ovs.models.entities.Certification;
import edu.estu.ovs.models.entities.School;
import edu.estu.ovs.service.abstracts.CandidateService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class CandidateManager implements CandidateService {

    private final CandidateDao candidateDao;
    private final CertificationDao certDao;
    private final SchoolDao schDao;
    private final ModelMapper modelMapper;

    @Override
    public ApiResult save(CandidateDto candidateDto) {
        return new ApiSuccessDataResult<>(Msg.SAVED, candidateDao.save(modelMapper.map(candidateDto, Candidate.class)));
    }

    @Override
    public ApiResult getAll() {
        return new ApiSuccessDataResult<>(candidateDao.findAll());
    }

    @Override
    public ApiResult updateVerification(Integer uid, Boolean status) {
        Candidate candidate = candidateDao.findById(uid).orElseThrow(EntityNotFoundException::new);
        candidate.setVerified(status);
        return new ApiSuccessDataResult<>(Msg.SAVED, candidateDao.save(candidate));
    }

    @Override
    public ApiResult saveCertification(CertificationDto certDto) {
        certDao.save(modelMapper.map(certDto, Certification.class));
        return new ApiSuccessDataResult<>(Msg.SAVED, candidateDao.getById(certDto.getCandidateId()));
    }

    @Override
    public ApiResult saveSchool(SchoolDto schDto) {
        schDao.save(modelMapper.map(schDto, School.class));
        return new ApiSuccessDataResult<>(Msg.SAVED, candidateDao.getById(schDto.getCandidateId()));
    }

    @Override
    public ApiResult removeCertification(Integer certId) {
        Integer candId = certDao.findById(certId).orElseThrow(EntityNotFoundException::new).getCandidate().getUid();
        certDao.deleteById(certId);
        return new ApiSuccessDataResult<>(Msg.REMOVED, candidateDao.getById(candId));
    }

    @Override
    public ApiResult removeSchool(Integer schId) {
        Integer candId = schDao.findById(schId).orElseThrow(EntityNotFoundException::new).getCandidate().getUid();
        schDao.deleteById(schId);
        return new ApiSuccessDataResult<>(Msg.REMOVED, candidateDao.getById(candId));
    }

}
