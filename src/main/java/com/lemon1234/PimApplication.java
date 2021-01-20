package com.lemon1234;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lemon1234.mapper")
public class PimApplication {

	// https://blog.csdn.net/qq_16681279/article/details/109628726 elasticSearch
	public static void main(String[] args) {
		SpringApplication.run(PimApplication.class, args);
	}

}
