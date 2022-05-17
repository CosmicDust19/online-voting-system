package edu.estu.ovs.core.validation.annotations;

import edu.estu.ovs.core.utilities.Msg;
import edu.estu.ovs.core.validation.validators.ExistsValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = ExistsValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RUNTIME)
public @interface Exists {

    String column();

    String table();

    String message() default Msg.NOT_EXIST;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
