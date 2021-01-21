package com.lemon1234.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import com.lemon1234.entity.dict.Constants;
import com.lemon1234.sys.result.Result;
import com.lemon1234.util.HttpUtil;

@Component
public class UserAuthAccessDeniedHandler implements AccessDeniedHandler {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		HttpUtil.print(response, Result.error(Constants.HTTP_401, "抱歉您无权进入"));
	}

}
