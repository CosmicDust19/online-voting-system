package edu.estu.ovs.core.utilities;

import lombok.SneakyThrows;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.annotation.Annotation;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;

public class ReflectionUtils {

    public static List<Object> getAnnotatedArgs(Parameter[] params, Object[] args, Class<? extends Annotation> searchAnnotation) {
        List<Object> annotatedArgs = new ArrayList<>();
        for (int i = 0; i < args.length; i++)
            if (params[i].isAnnotationPresent(searchAnnotation))
                annotatedArgs.add(args[i]);
        return annotatedArgs;
    }

    @SneakyThrows
    public static Parameter[] getMethodParameters(Class<?> theClass, MethodSignature signature) {
        return theClass.getMethod(signature.getMethod().getName(), signature.getMethod().getParameterTypes()).getParameters();
    }

}
