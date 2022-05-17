package edu.estu.ovs.api.controllers;

import edu.estu.ovs.core.response.results.abstracts.ApiResult;
import edu.estu.ovs.core.utilities.Constants;
import edu.estu.ovs.core.validation.annotations.Exists;
import edu.estu.ovs.core.validation.groups.OnCreate;
import edu.estu.ovs.core.validation.groups.OnUpdate;
import edu.estu.ovs.models.dtos.CandidateDto;
import edu.estu.ovs.models.dtos.CertificationDto;
import edu.estu.ovs.models.dtos.SchoolDto;
import edu.estu.ovs.service.abstracts.CandidateService;
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

    @PostMapping("/update")
    public ResponseEntity<ApiResult> update(@Validated(OnUpdate.class) @RequestBody CandidateDto candidateDto) {
        return buildResponseEntity(candidateService.save(candidateDto));
    }

    @PostMapping("/update/verified")
    public ResponseEntity<ApiResult> updateVerification(
            @Exists(column = "uid", table = "candidate") @RequestParam Integer uid, @RequestParam Boolean status) {
        return buildResponseEntity(candidateService.updateVerification(uid, status));
    }

    @PostMapping("/add/certification")
    public ResponseEntity<ApiResult> addCertification(@Validated(OnCreate.class) @RequestBody CertificationDto certDto) {
        return buildResponseEntity(candidateService.saveCertification(certDto));
    }

    @PostMapping("/add/school")
    public ResponseEntity<ApiResult> addSchool(@Validated(OnCreate.class) @RequestBody SchoolDto schDto) {
        return buildResponseEntity(candidateService.saveSchool(schDto));
    }

}
