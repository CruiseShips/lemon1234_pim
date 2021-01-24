package com.lemon1234.config.oauth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import com.lemon1234.sys.result.Result;
import com.lemon1234.util.HttpUtil;

/**
 * 退出成功
 * 
 * @date 2021年1月24日
 * @author lemon1234.zhihua
 */
@Component
public class AdminLogoutSuccessHandler implements LogoutSuccessHandler {

	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		HttpUtil.print(response, Result.success("成功退出"));
	}

}
