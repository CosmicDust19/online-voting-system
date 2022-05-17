package edu.estu.ovs.core.validation.annotations;

import edu.estu.ovs.core.utilities.Msg;
import edu.estu.ovs.core.validation.validators.NoScheduleConflictValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = NoScheduleConflictValidator.class)
@Target({ElementType.TYPE}) // target class should implement schedulable interface
@Retention(RUNTIME)
public @interface NoScheduleConflict {

    String message() default Msg.START_END_CONFLICT;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
