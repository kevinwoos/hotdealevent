package com.garage.poc.swagger.config;

import java.util.Collections;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableAutoConfiguration
public class SwaggerConfig {                                   

	@Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2) 
          .select()                                 
          .apis(RequestHandlerSelectors.any())	// 현재 RequestMapping으로 할당된 모든 URL 리스트를 추출
          .paths(PathSelectors.any())			// 모든 URL 노출
          										// 그중 /api/** 인 URL들만 필터링하고 싶다면
          										// .paths(PathSelectors.ant("/api/**"))
          .build();
    }
    private ApiInfo apiInfo() {
        return new ApiInfo(
          "Hello REST API",
          "Some custom description of API.",
          "API TOS",
          "Terms of service",
          new Contact("야훔", "www.example.com", "myeaddress@company.com"),
          "License of API", "API license URL", Collections.emptyList());
   }
}