package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@EnableSwagger2
@SpringBootApplication
public class Sb8Application {

	public static void main(String[] args) {
		SpringApplication.run(Sb8Application.class, args);
	}
	@Bean
	public Docket few()
	{
		return new Docket(DocumentationType.SWAGGER_2).
				select().paths(PathSelectors.ant("/api/*")).
				apis(RequestHandlerSelectors.
						basePackage("com.example.demo")).
				build().apiInfo(apiDetails());
	}
	private ApiInfo apiDetails()
	{
		return new ApiInfo("Product Application", "Products selling promotions",
				"5.9", "Restricted to other users", "Product owner", 
				"Owner licensed ", "products.in");
	}
}
