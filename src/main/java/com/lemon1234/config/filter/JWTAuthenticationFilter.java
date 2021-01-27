package com.lemon1234.config.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.stereotype.Component;

import com.lemon1234.entity.dict.Constants;
import com.lemon1234.sys.result.JwtResult;
import com.lemon1234.sys.result.Result;
import com.lemon1234.util.HttpUtil;
import com.lemon1234.util.JwtUtils;
import com.lemon1234.util.StringUtil;

@Component
public class JWTAuthenticationFilter extends BasicAuthenticationFilter {
	
	private Logger logger = LoggerFactory.getLogger(JWTAuthenticationFilter.class);

	public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
		super(authenticationManager);
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		logger.info("请求路径：" + request.getRequestURI());
		
		String token = request.getHeader("token");
		
		if(StringUtil.isEmpty(token)) {
			HttpUtil.print(response, Result.error(Constants.HTTP_401, "JWT 签名验证不存在"));
			return;
		} else {
			JwtResult jwtResult = JwtUtils.validateJWT(token);
			if(jwtResult.isSuccess()) {
				super.doFilterInternal(request, response, chain);
			} else {
				if(jwtResult.getErrCode() == Constants.JWT_ERRCODE_FAIL) {
					HttpUtil.print(response, Result.error(Constants.HTTP_401, "JWT 签名验证不通过"));
					return;
				} else if(jwtResult.getErrCode() == Constants.JWT_ERRCODE_EXPIRE) {
					HttpUtil.print(response, Result.error(Constants.HTTP_401, "JWT 签名验证过期"));
					return;
				}
			}
		}
		
	}

}
