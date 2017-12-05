package com.jiapengcs.alpha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class BlogAlphaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogAlphaApplication.class, args);
	}
}
