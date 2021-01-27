package com.lemon1234.config.filter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * 重写登录请求的过滤器
 * 
 * @date 2021年1月26日
 * @author lemon1234.zhihua
 */
public class AdminUsernamePasswordFilter extends UsernamePasswordAuthenticationFilter {
	
	private Logger logger = LoggerFactory.getLogger(AdminUsernamePasswordFilter.class);

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		// 如果不是 JSON 格式请求直接抛出异常
		if (!request.getContentType().equals(MediaType.APPLICATION_JSON_VALUE)
				&& !request.getMethod().equals("POST")) {
			throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
		}
		
		BufferedReader br = null;
		String param = null;
		try {
			br = new BufferedReader(new InputStreamReader(request.getInputStream(), "utf-8"));
	        StringBuffer sb = new StringBuffer("");
	        String temp;
	        while ((temp = br.readLine()) != null) {
	            sb.append(temp);
	        }
	        param = sb.toString();
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			if(br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
        
		if(param != null) {
			JSONObject object = JSON.parseObject(param);
			String username = (String) object.get("username");
			String password = (String) object.get("password");
			
			username = (username != null) ? username : "";
			username = username.trim();
			password = (password != null) ? password : "";
			
			UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);
			setDetails(request, authRequest);
			return this.getAuthenticationManager().authenticate(authRequest);
		} else {
			return null;
		}
	}
	
	
	
}
