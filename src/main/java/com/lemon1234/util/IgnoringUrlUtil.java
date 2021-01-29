package com.lemon1234.util;

public class IgnoringUrlUtil {

	public static String[] ignoringUrl() {
		// 不进行权限验证的请求或资源
    	String[] matchers = new String[] {
    			// swaggerui 的 不进行权限拦截的请求
    			"/swagger*//**", 
    			"/v2/api-docs",
    			"/swagger-resources/**",
    			"/swagger-ui.html",
    			"/webjars/**",
    			"/*.html"
    			};
    	
    	return matchers;
	}
}
