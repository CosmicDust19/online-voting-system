package edu.estu.ovs.core.validation.validators;

import edu.estu.ovs.core.validation.annotations.Exists;
import edu.estu.ovs.core.utilities.ValidationUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ExistsValidator implements ConstraintValidator<Exists, Object> {

    private Exists constraint;

    @Override
    public void initialize(Exists constraint) {
        this.constraint = constraint;
        ConstraintValidator.super.initialize(constraint);
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        return ValidationUtils.existsByField(constraint.table(), constraint.column(), String.valueOf(value));
    }

}
