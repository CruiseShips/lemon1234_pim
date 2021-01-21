package com.lemon1234;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lemon1234.mapper")
public class PimApplication {

	public static void main(String[] args) {
		SpringApplication.run(PimApplication.class, args);
	}

	// spring security
	// https://blog.csdn.net/qq_41910048/article/details/104997710
}
