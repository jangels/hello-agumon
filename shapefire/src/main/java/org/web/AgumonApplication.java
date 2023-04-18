package org.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
@MapperScan({"org.web.base.mapper"})
@EnableDiscoveryClient
public class AgumonApplication {

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(AgumonApplication.class, args);
        while(true) {
            //当动态配置刷新时，会更新到 Enviroment中，因此这里每隔10秒中从Enviroment中获取配置
            String userName = applicationContext.getEnvironment().getProperty("user.name");
            String userAge = applicationContext.getEnvironment().getProperty("user.age");
            String env = applicationContext.getEnvironment().getProperty("current.env");
            System.err.println("user name :" + userName + "; age: " + userAge);
            System.err.println("env  :" + env);
            TimeUnit.SECONDS.sleep(10);
        }
    }


}
