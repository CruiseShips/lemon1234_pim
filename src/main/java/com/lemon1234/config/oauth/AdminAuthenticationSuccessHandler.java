package com.lemon1234.config.oauth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.lemon1234.entity.Admin;
import com.lemon1234.sys.result.Result;
import com.lemon1234.util.HttpUtil;
import com.lemon1234.util.JwtUtils;

/**
 * 登录成功
 * 
 * @date 2021年1月24日
 * @author lemon1234.zhihua
 */
@Component
public class AdminAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		Admin admin = (Admin) authentication.getPrincipal();
		String token = JwtUtils.createJWT(admin.getId(), JSON.toJSONString(authentication.getAuthorities()), JwtUtils.TIMEOUT);
		
		HttpUtil.print(response, Result.success("用户成功登录", token));
	}

}
