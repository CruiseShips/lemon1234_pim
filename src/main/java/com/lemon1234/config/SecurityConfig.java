package com.lemon1234.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
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

import com.lemon1234.config.filter.AdminUsernamePasswordFilter;
import com.lemon1234.config.filter.JWTAuthenticationFilter;
import com.lemon1234.config.filter.WebSecurityCorsFilter;
import com.lemon1234.config.oauth.AdminAccessDeniedHandler;
import com.lemon1234.config.oauth.AdminAuthenticationEntryPoint;
import com.lemon1234.config.oauth.AdminAuthenticationFailureHandler;
import com.lemon1234.config.oauth.AdminAuthenticationProvider;
import com.lemon1234.config.oauth.AdminAuthenticationSuccessHandler;
import com.lemon1234.config.oauth.AdminLogoutSuccessHandler;
import com.lemon1234.util.IgnoringUrlUtil;

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
	
	// 登录成功
	@Autowired
	private AdminAuthenticationSuccessHandler adminAuthenticationSuccessHandler;
	
	// 登录失败
	@Autowired
	private AdminAuthenticationFailureHandler adminAuthenticationFailureHandler;
	
	// 退出
	@Autowired
	private AdminLogoutSuccessHandler adminLogoutSuccessHandler;
	
	// 自定义登录
	@Autowired
	private AdminAuthenticationProvider adminAuthenticationProvider;
	
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
        // 可以直接访问的静态数据
        web.ignoring()
                .antMatchers("/css/**")
                .antMatchers("/404.html")
                .antMatchers("/500.html")
                .antMatchers("/html/**")
                .antMatchers("/js/**")
                .antMatchers(HttpMethod.OPTIONS, "/**");
    }
    

    // 加入自定义的安全认证
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(adminAuthenticationProvider);
    }
	
    // 配置security的控制逻辑
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	
    	// 基于Token不需要session
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        
        // 禁用缓存
        http.headers().cacheControl();
        
        http.cors().and()
        	.csrf().disable()
        	.authorizeRequests()
        	// 用于配置直接放行的请求
        	.antMatchers(IgnoringUrlUtil.ignoringUrl()).permitAll()
        	// 其余请求都需要验证
	        .anyRequest().authenticated()
	        .and()
	        // 开启登录
	        .formLogin()
        	// 登录成功
        	// .successHandler(adminAuthenticationSuccessHandler)
        	// 登录失败
        	// .failureHandler(adminAuthenticationFailureHandler)
        	// .permitAll()
        	.and()
            // 注销成功
            .logout().logoutSuccessHandler(adminLogoutSuccessHandler)
            .permitAll()
            .and()
            .exceptionHandling()
            // 未登录请求资源
            .authenticationEntryPoint(adminAuthenticationEntryPoint)
            // 没有权限
            .accessDeniedHandler(adminAccessDeniedHandler)
            .and().addFilterBefore(webSecurityCorsFilter, ChannelProcessingFilter.class)
		          .addFilterBefore(jWTAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
		          .addFilterAt(adminUsernamePasswordFilter(), UsernamePasswordAuthenticationFilter.class)
            ;
    }
    
    /**
     * 自定义登录组件
     * 
     * @return
     * @throws Exception
     */
    @Bean
    public AdminUsernamePasswordFilter adminUsernamePasswordFilter() throws Exception {
    	AdminUsernamePasswordFilter filter = new AdminUsernamePasswordFilter();
    	filter.setAuthenticationManager(authenticationManagerBean());
    	filter.setAuthenticationSuccessHandler(adminAuthenticationSuccessHandler);
    	filter.setAuthenticationFailureHandler(adminAuthenticationFailureHandler);
    	return filter;
    }
    
    /**
     * JWT 过滤器
     * 
     * @return
     * @throws Exception
     */
    @Bean
    public JWTAuthenticationFilter jWTAuthenticationFilter() throws Exception {
    	JWTAuthenticationFilter jwtFilter = new JWTAuthenticationFilter(authenticationManagerBean());
    	return jwtFilter;
    }
    
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
