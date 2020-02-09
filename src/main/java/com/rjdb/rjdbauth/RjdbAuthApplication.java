package com.rjdb.rjdbauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class RjdbAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(RjdbAuthApplication.class, args);
	}
	
	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/v1/**"))
				.apis(RequestHandlerSelectors.basePackage("com.rjdb.rjdbauth"))
				.build()
				.apiInfo(apiDetails());
	}
	
	private ApiInfo apiDetails() {
		ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder().title("Topic and Course Rest API").contact(new springfox.documentation.service.Contact("Aditya", "http://pat4less.com", "aditya@anwisys.com")).version("1.0");
		
		return apiInfoBuilder.build();
	}

}
