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
	
	// Elasticsearch 配置
		// https://blog.csdn.net/chengyuqiang/article/details/102938266
	
	// springboot mail 配置
		// https://blog.csdn.net/yimcarson/article/details/84936440
	
	// JWT 拦截器
		// 这个没有写~~~
		// https://www.cnblogs.com/zzb-yp/p/11899880.html
		// 按照下面的去做
		// https://zhuanlan.zhihu.com/p/95560389?from_voters_page=true
}
