package com.lemon1234.config.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.lemon1234.entity.Admin;
import com.lemon1234.entity.dict.Constants;
import com.lemon1234.service.AdminService;
import com.lemon1234.sys.result.JwtResult;
import com.lemon1234.sys.result.Result;
import com.lemon1234.util.HttpUtil;
import com.lemon1234.util.JwtUtils;
import com.lemon1234.util.StringUtil;

/**
 * JWT 拦截器
 * 
 * @date 2021年1月29日
 * @author lemon1234.zhihua
 */
@Component
public class JWTAuthenticationFilter extends OncePerRequestFilter {
	
	@Autowired
	private AdminService adminService;
	
	private Logger logger = LoggerFactory.getLogger(JWTAuthenticationFilter.class);

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// 获取头请求中的 token
		String token = request.getHeader("token");
		
		logger.info("请求路径：" + request.getRequestURI() + "，请求 token：" + token);
		
		if(StringUtil.isNotEmpty(token)) {
			JwtResult jwtResult = JwtUtils.validateJWT(token);
			
			if(jwtResult.isSuccess()) {
				String username = jwtResult.getClaims().getId();
				
				if(SecurityContextHolder.getContext().getAuthentication() != null) {
					filterChain.doFilter(request, response);
					return;
				}
				
				// 这里可以进行优化，放入 redis 中
				Admin admin = (Admin)adminService.loadUserByUsername(username);
				// 存放到节点中，方便下一个过滤器进行过滤
				UsernamePasswordAuthenticationToken upat = new UsernamePasswordAuthenticationToken(admin, null, admin.getAuthorities());
				SecurityContextHolder.getContext().setAuthentication(upat);
				
				filterChain.doFilter(request, response);
			} else {
				if(jwtResult.getErrCode() == Constants.JWT_ERRCODE_FAIL) {
					HttpUtil.print(response, Result.error(Constants.JWT_ERRCODE_FAIL, "JWT 签名验证不通过"));
					return;
				} else if(jwtResult.getErrCode() == Constants.JWT_ERRCODE_EXPIRE) {
					HttpUtil.print(response, Result.error(Constants.JWT_ERRCODE_EXPIRE, "JWT 签名验证过期"));
					return;
				}
			}
			
		} else {
			filterChain.doFilter(request, response);
		}
		// ---
	}

}
