package org.web.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@Component
@EnableSwagger2
public class CommonSwaggerConfig {

    @Bean
    @ConditionalOnMissingBean
    public Docket createRestApi() {

        /*
         * 全局配置
         */
        Parameter param = null;
        List<Parameter> aParameters = new ArrayList<>();
        param = new ParameterBuilder().name("sessionId").description("会话Id").modelRef(new ModelRef("string")).parameterType("header").required(false).build();

        aParameters.add(param);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.web"))
                .paths(PathSelectors.any())
                .build().enable(true)
                .globalOperationParameters(aParameters);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("smallfire server 1.0.0")
                .description("smallfire server ")
                .version("1.0.0")
                .build();
    }
}