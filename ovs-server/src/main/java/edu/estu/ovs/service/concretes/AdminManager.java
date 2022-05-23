package edu.estu.ovs.service.concretes;

import edu.estu.ovs.core.results.abstracts.ApiResult;
import edu.estu.ovs.core.results.success.ApiSuccessDataResult;
import edu.estu.ovs.core.utilities.Msg;
import edu.estu.ovs.dataaccess.abstracts.AdminDao;
import edu.estu.ovs.models.dtos.AdminDto;
import edu.estu.ovs.models.entities.Admin;
import edu.estu.ovs.models.entities.Authority;
import edu.estu.ovs.models.enums.RoleName;
import edu.estu.ovs.service.abstracts.AdminService;
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
public class AdminManager implements AdminService {

    private final AdminDao adminDao;
    private final ModelMapper modelMapper;

    @Override
    public ApiResult save(AdminDto adminDto) {
        Admin admin = modelMapper.map(adminDto, Admin.class);
        admin.setAuthorities(new ArrayList<>(List.of(new Authority(3, RoleName.ROLE_ADMIN))));
        return new ApiSuccessDataResult<>(HttpStatus.CREATED, Msg.SAVED, adminDao.save(admin));
    }

    @Override
    public ApiResult getAll() {
        return new ApiSuccessDataResult<>(adminDao.findAll());
    }

}
