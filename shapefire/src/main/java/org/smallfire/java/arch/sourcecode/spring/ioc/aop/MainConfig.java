package org.smallfire.java.arch.sourcecode.spring.ioc.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by xsls on 2019/6/10.
 */
@Configuration
@EnableAspectJAutoProxy   /*<aop:aspectj-autoproxy/>*/
//(exposeProxy = true) //(proxyTargetClass = true)
@ComponentScan("tuling")
public class MainConfig {

     @Bean
    public Calculate calculate() {
        return new TulingCalculate();
    }

    @Bean
    public TulingLogAspect tulingLogAspect() {
        return new TulingLogAspect();
    }


    @Bean
    public Calculate calculate2() {
        return new TulingCalculate();
    }
}
