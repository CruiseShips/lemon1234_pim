package com.lemon1234.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import com.lemon1234.entity.dict.Constants;
import com.lemon1234.sys.result.JwtResult;
import com.lemon1234.sys.result.Result;
import com.lemon1234.util.HttpUtil;
import com.lemon1234.util.JwtUtils;
import com.lemon1234.util.StringUtil;

/**
 * 系统拦截器
 * 
 * @date 2021年1月19日
 * @author lemon1234.zhihua
 */
public class SysInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		String contextPath = request.getRequestURI();
		
		System.out.println(contextPath);
		
		String token = request.getHeader("token");
		if(StringUtil.isEmpty(token)) {
			HttpUtil.print(response, Result.error(Constants.REQUESTCODE.HTTP_500.getDictValue(), "签名验证不存在"));
            return false;
		} else {
			JwtResult jwtResult = JwtUtils.validateJWT(token);
			if(jwtResult.isSuccess()){
                return true;
            }else{
                switch (jwtResult.getErrCode()){
                    case 4001:
                    	HttpUtil.print(response, Result.error(Constants.REQUESTCODE.HTTP_500.getDictValue(), "签名验证不通过"));
                        break;
                    case 4002:
                    	HttpUtil.print(response, Result.error(Constants.REQUESTCODE.HTTP_500.getDictValue(), "签名验证过期"));
                        break;
                }
                return false;
            }
		}
	}
}
