package com.lemon1234.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.lemon1234.config.filter.JWTAuthenticationFilter;
import com.lemon1234.config.filter.WebSecurityCorsFilter;
import com.lemon1234.config.oauth.AdminAccessDeniedHandler;
import com.lemon1234.config.oauth.AdminAuthenticationEntryPoint;
import com.lemon1234.service.AdminService;

/**
 * SpringSecurity 安全配置类
 * 
 * @date 2021年1月19日
 * @author lemon1234.zhihua
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	// 自定义登录
	@Autowired
	private AdminService adminService;
	
	// 未登录
	@Autowired
	private AdminAuthenticationEntryPoint adminAuthenticationEntryPoint;
	
	// 没有权限
	@Autowired
	private AdminAccessDeniedHandler adminAccessDeniedHandler;
	
	// 跨域过滤器
	@Autowired
	private WebSecurityCorsFilter webSecurityCorsFilter;
	
	/**
	 * 加密方式
	 * @return
	 */
	@Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
	
	// 描述: 静态资源放行，这里的放行，是不走 Spring Security 过滤器链
    @Override
    public void configure(WebSecurity web) {
    	String[] matchers = new String[] {
    			// swaggerui 的 不进行权限拦截的请求
    			"/swagger*//**", 
    			"/v2/api-docs",
    			"/swagger-resources/**",
    			"/swagger-ui.html",
    			"/webjars/**",
    			"/*.html",
    			"/file/**",
    			"/favicon.ico",
    			"/admin/login",
    			"/admin/logout",
    			"/admin/updToken",
    			};
        // 可以直接访问的静态数据
    	web.ignoring().antMatchers(matchers);
    }
    
    

    // 加入自定义的安全认证
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(adminService).passwordEncoder(bCryptPasswordEncoder());
    }
	
    // 配置security的控制逻辑
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	
    	// 基于Token不需要session
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        
        // 禁用缓存
        http.headers().cacheControl();
        
        // 开启跨域，关闭 csrf
        http.cors().and()
        	.csrf().disable();
        
        // 添加请求拦截、不放行任何请求，除去不进入拦截器的放行接口
        http.authorizeRequests()
        	// 其余请求都需要验证
	        .anyRequest().authenticated();
        
        // 添加 CORS 过滤器，添加JWT验证拦截器
        http.addFilterBefore(webSecurityCorsFilter, ChannelProcessingFilter.class)
        	.addFilterBefore(jWTAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
        
        // 退出成功
        // http.logout().logoutSuccessHandler(adminLogoutSuccessHandler).permitAll();
        
        http.exceptionHandling()
        	// 未登录请求资源
        	.authenticationEntryPoint(adminAuthenticationEntryPoint)
        	// 没有权限
        	.accessDeniedHandler(adminAccessDeniedHandler);
    }
    
    /**
     * JWT 过滤器
     * 
     * @return
     * @throws Exception
     */
    @Bean
    public JWTAuthenticationFilter jWTAuthenticationFilter() throws Exception {
    	JWTAuthenticationFilter jwtFilter = new JWTAuthenticationFilter();
    	return jwtFilter;
    }
}
