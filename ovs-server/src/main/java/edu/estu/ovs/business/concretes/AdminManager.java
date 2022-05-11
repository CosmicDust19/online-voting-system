package edu.estu.ovs.business.concretes;

import edu.estu.ovs.business.abstracts.AdminService;
import edu.estu.ovs.core.utilities.Msg;
import edu.estu.ovs.core.utilities.results.DataResult;
import edu.estu.ovs.core.utilities.results.Result;
import edu.estu.ovs.core.utilities.results.SuccessDataResult;
import edu.estu.ovs.dataAccess.AdminDao;
import edu.estu.ovs.models.dtos.UserCrDto;
import edu.estu.ovs.models.entities.Admin;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminManager implements AdminService {

    private final AdminDao adminDao;
    private final ModelMapper modelMapper;

    @Override
    public DataResult<List<Admin>> getAll() {
        return new SuccessDataResult<>(adminDao.findAll());
    }

    @Override
    public Result add(UserCrDto userCrDto) {
        /*userCheck.notExistsUserByEmail(employerAddDto.getEmail(), null);
        employerCheck.notExistsEmployerByCompanyName(employerAddDto.getCompanyName(), null);
        employerCheck.notExistsEmployerByWebsite(employerAddDto.getWebsite(), null);
        employerCheck.emailWebsiteHaveTheSameDomain(employerAddDto.getEmail(), employerAddDto.getWebsite());
        ErrorDataResult<ApiError> errors = Utils.getErrorsIfExist(userCheck, employerCheck);
        if (errors != null) return errors;*/

        /*emailService.sendVerificationMail(employerAddDto.getEmail());
        employerAddDto.setPhoneNumber(Utils.getEditedPhoneNumber(employerAddDto.getPhoneNumber()));*/
        Admin admin = modelMapper.map(userCrDto, Admin.class);
        Admin savedAdmin = adminDao.save(admin);
        savedAdmin.setPassword(null);
        return new SuccessDataResult<>(Msg.SAVED, savedAdmin);
    }

}
