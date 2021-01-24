package com.lemon1234.config.oauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.www.NonceExpiredException;
import org.springframework.stereotype.Component;

import com.lemon1234.entity.Admin;
import com.lemon1234.service.AdminService;

/**
 * 自定义登录
 * 
 * @date 2021年1月24日
 * @author lemon1234.zhihua
 */
@Component
public class AdminAuthenticationProvider implements AuthenticationProvider {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String userName = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();
        
        Admin admin = (Admin) adminService.loadUserByUsername(userName);
        if(admin == null) {
        	throw new UsernameNotFoundException("未找到该用户");
        }
        if(!bCryptPasswordEncoder.matches(password, admin.getPassword())) {
        	throw new BadCredentialsException("密码错误");
        }
        if(!admin.isEnabled()) {
        	throw new NonceExpiredException("用户已被封，请联系管理员");
        }
        
        return new UsernamePasswordAuthenticationToken(admin, password, admin.getAuthorities());
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}

}
