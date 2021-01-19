package com.lemon1234.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.lemon1234.interceptor.SysInterceptor;

@Component("webMvcComponent")
public class WebMvcConfig implements WebMvcConfigurer {

	/**
	 * 跨域配置
	 */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .allowCredentials(true)
                .allowedMethods("*")
                .maxAge(3600);
    }

    /**
     * 添加拦截器
     */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new SysInterceptor())
			.addPathPatterns("/**")
			.excludePathPatterns("/api/login");
	}
    
}
