package edu.estu.ovs.api.controllers;

import edu.estu.ovs.core.results.abstracts.ApiResult;
import edu.estu.ovs.core.utilities.Constants;
import edu.estu.ovs.core.validation.annotations.Exists;
import edu.estu.ovs.core.validation.groups.OnCreate;
import edu.estu.ovs.core.validation.groups.OnUpdate;
import edu.estu.ovs.models.dtos.CandidateDto;
import edu.estu.ovs.models.dtos.CertificationDto;
import edu.estu.ovs.models.dtos.SchoolDto;
import edu.estu.ovs.service.abstracts.CandidateService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static edu.estu.ovs.core.utilities.Utils.buildResponseEntity;

@CrossOrigin(origins = {Constants.Origin.LOCALHOST_3000})
@RestController
@RequestMapping("/candidate")
@RequiredArgsConstructor
@Validated
@Api(tags = "Candidate")
public class CandidateController {

    private final CandidateService candidateService;

    @GetMapping("/get/all")
    public ResponseEntity<ApiResult> getAll() {
        return buildResponseEntity(candidateService.getAll());
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResult> create(@Validated(OnCreate.class) @RequestBody CandidateDto candidateDto) {
        return buildResponseEntity(candidateService.save(candidateDto));
    }

    @PutMapping("/update")
    public ResponseEntity<ApiResult> update(@Validated(OnUpdate.class) @RequestBody CandidateDto candidateDto) {
        return buildResponseEntity(candidateService.save(candidateDto));
    }

    @PatchMapping("/patch/certifications/add")
    public ResponseEntity<ApiResult> addCertification(@Validated(OnCreate.class) @RequestBody CertificationDto certDto) {
        return buildResponseEntity(candidateService.saveCertification(certDto));
    }

    @PatchMapping("/patch/certifications/update")
    public ResponseEntity<ApiResult> updateCertification(@Validated(OnUpdate.class) @RequestBody CertificationDto certDto) {
        return buildResponseEntity(candidateService.saveCertification(certDto));
    }

    @PatchMapping("/patch/certifications/remove")
    public ResponseEntity<ApiResult> removeCertification(
            @Exists(column = "cert_id", table = "candidate_certifications") @RequestParam Integer certId) {
        return buildResponseEntity(candidateService.removeCertification(certId));
    }

    @PatchMapping("/patch/schools/add")
    public ResponseEntity<ApiResult> addSchool(@Validated(OnCreate.class) @RequestBody SchoolDto schDto) {
        return buildResponseEntity(candidateService.saveSchool(schDto));
    }

    @PatchMapping("/patch/schools/update")
    public ResponseEntity<ApiResult> updateSchool(@Validated(OnUpdate.class) @RequestBody SchoolDto schDto) {
        return buildResponseEntity(candidateService.saveSchool(schDto));
    }

    @PatchMapping("/patch/schools/remove")
    public ResponseEntity<ApiResult> removeSchool(
            @Exists(column = "sch_id", table = "candidate_schools") @RequestParam Integer schId) {
        return buildResponseEntity(candidateService.removeSchool(schId));
    }

}
