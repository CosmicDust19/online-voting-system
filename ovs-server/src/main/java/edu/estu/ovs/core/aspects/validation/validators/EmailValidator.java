package edu.estu.ovs.core.aspects.validation.validators;

import edu.estu.ovs.core.aspects.validation.annotations.Email;
import edu.estu.ovs.dataAccess.UserDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
@RequiredArgsConstructor
public class EmailValidator implements ConstraintValidator<Email, String> {

    private final UserDao userDao;

    @Override
    public void initialize(Email constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        return userDao.existsByEmail(email);
    }
}
