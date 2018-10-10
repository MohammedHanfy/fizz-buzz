package com.hanfy.fizzbuzz.config;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.Collections;

import javax.servlet.ServletContext;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.paths.RelativePathProvider;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * The Class SwaggerConfiguration.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * Api.
     *
     * @param servletContext the servlet context
     * @return the docket
     */
    @Bean
    public Docket api(ServletContext servletContext) {
        return new Docket(DocumentationType.SWAGGER_2)
        		.host("localhost:8585")
                .pathProvider(new RelativePathProvider(servletContext) {
                    @Override
                    public String getApplicationBasePath() {
                        return "/";
                    }
                })
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(postPaths())
                .build()
                .apiInfo(apiInfo());
    }

    /**
     * Api info.
     *
     * @return the api info
     */
    private ApiInfo apiInfo() {
        return new ApiInfo(
                "FizzBuzz game API",
                "Description of The FizzBuzz game API.",
                "1.0",
                "Terms of service",
                new Contact("Mohammed Hanfy", null, "mohammed.ahmed.hanfy@gmail.com"),
                "License of API",
                "API license URL",
                Collections.emptyList());
    }

    /**
     * Post paths.
     *
     * @return the predicate
     */
    private Predicate<String> postPaths() {
        return regex("/*.*");
    }
}
