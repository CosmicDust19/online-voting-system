package edu.estu.ovs.core.validation.validators;

import edu.estu.ovs.core.validation.abstracts.Schedulable;
import edu.estu.ovs.core.validation.annotations.NoScheduleConflict;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NoScheduleConflictValidator implements ConstraintValidator<NoScheduleConflict, Schedulable<?>> {

    @Override
    public boolean isValid(Schedulable schedulable, ConstraintValidatorContext ctx) {
        //noinspection unchecked
        return schedulable.getStartDate().compareTo(schedulable.getEndDate()) < 0;
    }

}

