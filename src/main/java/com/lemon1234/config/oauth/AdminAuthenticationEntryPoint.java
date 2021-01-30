package com.lemon1234.config.oauth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.lemon1234.sys.result.Result;
import com.lemon1234.util.HttpUtil;

/**
 * 用户未登录
 * 
 * @date 2021年1月24日
 * @author lemon1234.zhihua
 */
@Component
public class AdminAuthenticationEntryPoint implements AuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		HttpUtil.print(response, Result.error("请登录~~"));
	}

}
