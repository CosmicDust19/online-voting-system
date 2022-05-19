package edu.estu.ovs.core.utilities.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ElementType.PARAMETER})
@Retention(RUNTIME)
public @interface PhoneNumber {
    // format phone number before method:
    // edu.estu.ovs.core.aspects.PhoneNumberAspect.editPhoneNumber
}
