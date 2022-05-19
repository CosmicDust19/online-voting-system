package edu.estu.ovs.core.aspects;

import edu.estu.ovs.core.utilities.AopUtils;
import edu.estu.ovs.core.utilities.Utils;
import edu.estu.ovs.core.utilities.annotations.PhoneNumber;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(0)
public class PhoneNumberAspect {

    @Around("execution(public * *(.., @edu.estu.ovs.core.utilities.annotations.PhoneNumber (*), ..))")
    public Object editPhoneNumber(final ProceedingJoinPoint pjp) throws Throwable {
        Object[] args = pjp.getArgs();
        List<Object> phoneNumbers = AopUtils.getAnnotatedArgs(pjp, PhoneNumber.class);
        for (int i = 0; i < args.length; i++)
            if (phoneNumbers.contains(args[i]))
                args[i] = Utils.getFormattedPhoneNumber(args[i].toString());
        return pjp.proceed(args);
    }

}
