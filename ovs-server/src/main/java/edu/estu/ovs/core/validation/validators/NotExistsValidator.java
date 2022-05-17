package edu.estu.ovs.core.validation.validators;

import edu.estu.ovs.core.validation.annotations.NotExists;
import edu.estu.ovs.core.utilities.ValidationUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NotExistsValidator implements ConstraintValidator<NotExists, Object> {

    private NotExists constraint;

    @Override
    public void initialize(NotExists constraint) {
        this.constraint = constraint;
        ConstraintValidator.super.initialize(constraint);
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext ctx) {
        if (value == null) return true;
        return !ValidationUtils.existsByField(constraint.table(), constraint.column(), String.valueOf(value));
    }

}
