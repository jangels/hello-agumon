package org.smallfire.java.arch.sourcecode.spring.ioc.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.smallfire.java.arch.sourcecode.spring.ioc.aop.Introductions.ProgramCalculate;
import org.smallfire.java.arch.sourcecode.spring.ioc.aop.Introductions.SimpleProgramCalculate;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by xsls on 2019/6/10.
 */
@Aspect
@Order
@Component
public class TulingLogAspect {

    /*引入:*/
    @DeclareParents(value="org.smallfire.java.arch.sourcecode.spring.ioc.aop.TulingCalculate",   // 动态实现的类
            defaultImpl = SimpleProgramCalculate.class)  // 引入的接口的默认实现
    public static ProgramCalculate programCalculate;    // 引入的接口

    @Pointcut("execution(* org.smallfire.java.arch.sourcecode.spring.ioc.aop.TulingCalculate.*(..))")
    public void pointCut(){};

    @Before(value = "pointCut()")
    public void methodBefore(JoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("执行目标方法【"+methodName+"】的<前置通知>,入参"+ Arrays.asList(joinPoint.getArgs()));
    }

    @After(value = "pointCut()")
    public void methodAfter(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("执行目标方法【"+methodName+"】的<后置通知>,入参"+Arrays.asList(joinPoint.getArgs()));
    }

    @AfterReturning(value = "pointCut()",returning = "result")
    public void methodReturning(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("执行目标方法【"+methodName+"】的<返回通知>,入参"+Arrays.asList(joinPoint.getArgs()));
    }

    @AfterThrowing(value = "pointCut()")
    public void methodAfterThrowing(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("执行目标方法【"+methodName+"】的<异常通知>,入参"+Arrays.asList(joinPoint.getArgs()));
    }

}
