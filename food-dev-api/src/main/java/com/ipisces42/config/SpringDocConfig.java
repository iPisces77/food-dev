package com.ipisces42.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * swagger配置
 */
@Configuration
public class SpringDocConfig {

    //    @Bean
//    public GroupedOpenApi publicApi() {
//        return GroupedOpenApi.builder()
//                .group("springshop-public")
//                .pathsToMatch("/public/**")
//                .build();
//    }
    @Bean
    public GroupedOpenApi adminApi() {
        return GroupedOpenApi.builder()
                .group("用户模块")
                .pathsToMatch("/**")
                .build();
    }

    @Bean
    OpenAPI springShopOpenAPI() {
        return new OpenAPI()
            .info(new Info().title("天天吃货")
                .description("接口文档")
                .version("v0.0.1")
                .license(new License().name("Apache 2.0").url("http://www.ipisces42.com")))
            .externalDocs(new ExternalDocumentation()
                .description("一些描述信息")
                .url("https://github.com/lenve/vhr"));
    }
}