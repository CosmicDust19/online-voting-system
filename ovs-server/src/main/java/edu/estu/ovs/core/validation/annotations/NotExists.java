package edu.estu.ovs.core.validation.annotations;

import edu.estu.ovs.core.utilities.Msg;
import edu.estu.ovs.core.validation.validators.NotExistsValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = NotExistsValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface NotExists {

    String column();

    String table();

    String message() default Msg.IS_IN_USE;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
