package edu.estu.ovs.service.concretes;

import edu.estu.ovs.core.response.results.abstracts.ApiResult;
import edu.estu.ovs.core.response.results.success.ApiSuccessDataResult;
import edu.estu.ovs.core.utilities.Msg;
import edu.estu.ovs.data.access.abstracts.AdminDao;
import edu.estu.ovs.models.dtos.AdminDto;
import edu.estu.ovs.models.entities.Admin;
import edu.estu.ovs.service.abstracts.AdminService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class AdminManager implements AdminService {

    private final AdminDao adminDao;
    private final ModelMapper modelMapper;

    @Override
    public ApiResult save(AdminDto adminDto) {
        return new ApiSuccessDataResult<>(Msg.SAVED, adminDao.save(modelMapper.map(adminDto, Admin.class)));
    }

    @Override
    public ApiResult getAll() {
        return new ApiSuccessDataResult<>(adminDao.findAll());
    }

    @Override
    public ApiResult updateVerification(Integer uid, Boolean status) {
        Admin admin = adminDao.findById(uid).orElseThrow(EntityNotFoundException::new);
        admin.setVerified(status);
        return new ApiSuccessDataResult<>(adminDao.save(admin));
    }

}
