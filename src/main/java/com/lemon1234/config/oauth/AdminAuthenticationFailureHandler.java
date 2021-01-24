package com.lemon1234.config.oauth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.lemon1234.sys.result.Result;
import com.lemon1234.util.HttpUtil;

/**
 * 登录失败
 * 
 * @date 2021年1月24日
 * @author lemon1234.zhihua
 */
@Component
public class AdminAuthenticationFailureHandler implements AuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		HttpUtil.print(response, Result.error(exception.getMessage()));
	}

}
