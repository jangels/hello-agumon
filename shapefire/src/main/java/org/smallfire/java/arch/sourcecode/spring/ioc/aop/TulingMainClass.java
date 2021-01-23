package org.smallfire.java.arch.sourcecode.spring.ioc.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by xsls on 2019/6/10.
 */
public class TulingMainClass {

    public static void main(String[] args) {

    	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfig.class);

      /**/
        Calculate calculate = (Calculate) ctx.getBean("tulingCalculate");
        int retVal = calculate.div(2,4);

        /*
         ProgramCalculate pcalculate = (ProgramCalculate) ctx.getBean("tulingCalculate");
        System.out.println(pcalculate.toBinary(100));
        */

    }

}
