package org.smallfire.java.arch.sourcecode.spring.ioc.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/***
 * @Author 徐庶   QQ:1092002729
 * @Slogan 致敬大师，致敬未来的你
 */
public class TulingLogInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println(getClass()+"调用方法前");
        Object ret=invocation.proceed();
        System.out.println(getClass()+"调用方法后");
        return ret;
    }

}
