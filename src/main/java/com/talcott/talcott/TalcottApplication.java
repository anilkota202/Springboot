package com.talcott.talcott;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import brave.Tracer;
import brave.Tracing;
import brave.sampler.Sampler;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@SpringBootApplication(scanBasePackages = "com.talcott.* ")
@EnableEurekaClient
@EnableDiscoveryClient
public class TalcottApplication {

	public static void main(String[] args) {
		SpringApplication.run(TalcottApplication.class, args);
	}
	
	@Bean
	public OpenAPI customOpenAPI(@Value("${application-description}") String appDesciption,
			@Value("${application-version}") String appVersion) {
		return new OpenAPI()
				.info(new Info().title("sample application API")
						.version(appVersion)
						.description(appDesciption)
						.termsOfService("http://swagger.io/terms/")
						.license(new License().name("Apache 2.0").url("http://springdoc.org")));

	}
	
	@Bean
	  public Tracer tracer() {
	    Tracing tracing = Tracing.newBuilder().build();
	    tracing.tracer().startScopedSpan("TestSpan");
	   
	    return tracing.tracer();
	  }
	

}
