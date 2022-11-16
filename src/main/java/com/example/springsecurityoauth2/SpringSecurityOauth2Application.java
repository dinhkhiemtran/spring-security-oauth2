package com.example.springsecurityoauth2;

import com.example.springsecurityoauth2.config.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import javax.persistence.Entity;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
@EntityScan(basePackageClasses = {
		SpringSecurityOauth2Application.class,
		Jsr310JpaConverters.class
})
public class SpringSecurityOauth2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityOauth2Application.class, args);
	}

}
