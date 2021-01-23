package org.smallfire.java.arch.sourcecode.spring.ioc.aop;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created by xsls on 2019/6/10.
 */

public class TulingLogAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        String methodName = method.getName();
        System.out.println("执行目标方法【" + methodName + "】的<前置通知>,入参" + Arrays.asList(args));
    }

}
