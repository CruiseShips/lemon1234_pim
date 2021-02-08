package com.lemon1234.controller.admin;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.lemon1234.entity.Admin;
import com.lemon1234.entity.dict.Constants;
import com.lemon1234.entity.dto.AdminLoginDTO;
import com.lemon1234.service.AdminService;
import com.lemon1234.sys.result.JwtResult;
import com.lemon1234.sys.result.Result;
import com.lemon1234.util.JwtUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "{管理端-系统模块}")
@RestController
@RequestMapping("/admin")
public class SysAdminController {
	
	private Logger logger = LoggerFactory.getLogger(SysAdminController.class);
	
	@Autowired
	private AdminService adminService;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@ApiOperation(value = "系统用户登录", notes = "不需要任何权限", httpMethod = "POST")
	@PostMapping("/login")
	public Result login(HttpServletRequest request, @RequestBody AdminLoginDTO dto) throws Exception {
		
		logger.info("登录人：" + dto.toString());
		
		Admin admin = (Admin) adminService.loadUserByUsername(dto.getUsername());
		if(admin == null) {
			return Result.error(Constants.HTTP_500, "无法识别该用户");
		}
		// 验证密码是否正确
        if(!bCryptPasswordEncoder.matches(dto.getPassword(), admin.getPassword())) {
        	// throw new BadCredentialsException("密码错误");
        	return Result.error(Constants.HTTP_500, "密码不正确");
        }
        // 判断用户是否封禁
        if(!admin.isEnabled()) {
        	// throw new NonceExpiredException("用户已被封，请联系管理员");
        	return Result.error(Constants.HTTP_500, "用户已被封，请联系管理员");
        }
		
        String auth = JSON.toJSONString(admin.getAuthorities());
		String token = JwtUtils.createJWT(admin.getUsername(), auth, JwtUtils.TIMEOUT);
		
		logger.info("登录人权限： " + auth);
		logger.info("生成 JWT Token：" + token);
		
		// 登录成功后，需要将数据放入整个的 Security中
		UsernamePasswordAuthenticationToken upat = new UsernamePasswordAuthenticationToken(admin, null, admin.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(upat);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("name", admin.getName());
		resultMap.put("img", admin.getImg());
		resultMap.put("token", token);
		
		return Result.success(resultMap);
	}
	
	@ApiOperation(value = "更新Token", notes = "不需要任何权限", httpMethod = "GET")
	@GetMapping("/updToken")
	public Result updToken(HttpServletRequest request, String token) throws Exception {
		JwtResult jwtResult = JwtUtils.validateJWT(token);
		if(jwtResult.isSuccess()) {
			String username = jwtResult.getClaims().getId();
			Admin admin = (Admin)adminService.loadUserByUsername(username);
			
			String auth = JSON.toJSONString(admin.getAuthorities());
			String newToken = JwtUtils.createJWT(admin.getUsername(), auth, JwtUtils.TIMEOUT);
			return Result.success(newToken);
		} else {
			if(jwtResult.getErrCode() == Constants.JWT_ERRCODE_FAIL) {
				return Result.error(Constants.JWT_ERRCODE_FAIL, "JWT 签名验证不通过");
			} else if(jwtResult.getErrCode() == Constants.JWT_ERRCODE_EXPIRE) {
				return Result.error(Constants.JWT_ERRCODE_FAIL, "JWT 签名验证过期");
			}
		}
		return null;
	}
	
	@ApiOperation(value = "退出", notes = "不需要任何权限", httpMethod = "GET")
	@GetMapping("/logout")
	public Result logout(HttpServletRequest request, String token) throws Exception {
		
		return Result.success();
	}
	
}
