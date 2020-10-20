package org.smallfire.server;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.Inet4Address;

@SpringBootApplication(scanBasePackages = "org.smallfire.server")
@MapperScan({"org.smallfire.server.base.mapper"})
@NacosPropertySource(dataId = "AGUMON-DEV.yml", groupId = "DEFAULT_GROUP", autoRefreshed = true)
public class AgumonApplication implements CommandLineRunner {

    @NacosInjected
    private NamingService namingService;

    @Override
    public void run(String... args) throws Exception {
        // 通过Naming服务注册实例到注册中心
        String hostAddress = Inet4Address.getLocalHost().getHostAddress();
        namingService.registerInstance("Agumon", hostAddress, 8080);
    }

    public static void main(String[] args) {
        SpringApplication.run(AgumonApplication.class, args);
    }


}
