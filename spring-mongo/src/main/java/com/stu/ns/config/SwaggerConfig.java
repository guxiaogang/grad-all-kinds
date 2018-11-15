package com.stu.ns.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.xml.datatype.XMLGregorianCalendar;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket cspApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .directModelSubstitute(XMLGregorianCalendar.class, String.class)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public UiConfiguration uiConfig() {
        return UiConfiguration.DEFAULT;
    }
}
