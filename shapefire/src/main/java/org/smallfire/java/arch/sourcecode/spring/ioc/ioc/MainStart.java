package org.smallfire.java.arch.sourcecode.spring.ioc.ioc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainStart {

    public static void main(String[] args)   {
        // 加载spring上下文
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);

        Car car =  context.getBean("car",Car.class);
        System.out.println(car.getName());
    }
}
