package com.lemon1234.handler;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.lemon1234.entity.Admin;
import com.lemon1234.sys.result.Result;
import com.lemon1234.util.HttpUtil;
import com.lemon1234.util.JwtUtils;

/**
 * 登录成功
 */
@Component
public class UserLoginSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		// HttpUtil.print(response, Result.success(JwtUtils.createJWT(admin.getId(), subject, JwtUtils.TIMEOUT)));
	}

}
