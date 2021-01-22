package com.lemon1234.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.lemon1234.entity.dict.Constants;
import com.lemon1234.sys.result.Result;
import com.lemon1234.util.HttpUtil;

/**
 * 登录失败
 */
@Component
public class UserLoginFailureHandler implements AuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		HttpUtil.print(response, Result.error(Constants.HTTP_600, "登录失败，请从新登录"));
	}
	
}
