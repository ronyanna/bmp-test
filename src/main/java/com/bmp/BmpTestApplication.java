package com.bmp;

import com.bmp.security.JwtProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableConfigurationProperties(JwtProperties.class)
@ComponentScan(basePackages = "com.bmp.*")
public class BmpTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(BmpTestApplication.class, args);
	}

}
