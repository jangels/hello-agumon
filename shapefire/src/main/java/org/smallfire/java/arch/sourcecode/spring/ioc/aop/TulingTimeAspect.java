package org.smallfire.java.arch.sourcecode.spring.ioc.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by xsls on 2019/6/10.
 */
/*@Aspect
@Order(0)
@Component*/
public class TulingTimeAspect {


    @Pointcut("execution(* org.smallfire.java.arch.sourcecode.spring.ioc.aop.TulingCalculate.*(..))")
    public void pointCut(){};

    long begin=0;

    @Before(value = "pointCut()")
    public void methodBefore() throws Throwable {
        begin = System.currentTimeMillis();
    }

    @After(value = "pointCut()")
    public void methodAfter(JoinPoint joinPoint) {
        long end = System.currentTimeMillis();
        String methodName = joinPoint.getSignature().getName();
        System.out.println("执行方法【"+methodName+"】耗时"+(end-begin));
    }


}
