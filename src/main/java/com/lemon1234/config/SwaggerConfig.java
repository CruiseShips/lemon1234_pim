package com.lemon1234.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger2 配置类
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket createRestApi() {
		
		StringBuffer sBuffer = new StringBuffer();
		sBuffer.append("希望你能看见让你大吃一惊的东西，\n");
		sBuffer.append("希望你会有前所未有的感受，\n");
		sBuffer.append("希望你能结交有着不同观点的人，\n");
		sBuffer.append("希望你的生活令你骄傲，\n");
		sBuffer.append("如果你发现事实并非如此，希望你能鼓起勇气！\n");
		sBuffer.append("一切从头再来！");
		
		// 配置一下 Swagger 文档类型
		Docket docket = new Docket(DocumentationType.SWAGGER_2);
		docket.pathMapping("/")
			  .select()
			  // 配置我们扫描的包 也可以配置成其他类型
			  .apis(RequestHandlerSelectors.basePackage("com.lemon1234.controller"))
			  .paths(PathSelectors.any())
			  // 添加一些 ApiInfo
			  .build().apiInfo(new ApiInfoBuilder()
                      .title("PIM 接口文档")
                      .description(sBuffer.toString())
                      .version("1.0.0")
                      .license("Apache 2.0 License")
                      .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0.txt")
                      .build());
		return docket;
	}
}
