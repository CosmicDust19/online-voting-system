package edu.estu.ovs.core.utilities;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.annotation.Annotation;
import java.lang.reflect.Parameter;
import java.util.List;

public class AopUtils {

    public static List<Object> getAnnotatedArgs(final ProceedingJoinPoint pjp, Class<? extends Annotation> annotation) {
        Parameter[] parameters = ReflectionUtils.getMethodParameters(pjp.getTarget().getClass(), (MethodSignature) pjp.getSignature());
        return ReflectionUtils.getAnnotatedArgs(parameters, pjp.getArgs(), annotation);
    }

}
