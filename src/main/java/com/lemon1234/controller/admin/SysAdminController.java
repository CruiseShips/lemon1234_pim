package com.lemon1234.controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lemon1234.sys.result.Result;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "{管理端-系统模块}")
@RestController
@RequestMapping("/admin")
public class SysAdminController {
	
	@ApiOperation(value = "更新Token", notes = "不需要任何权限", httpMethod = "GET")
	@GetMapping("/updToken")
	public Result login(HttpServletRequest request, String token) throws Exception {
		
		return Result.success();
	}
	
	@PostMapping("/login")
	public Result login(HttpServletRequest request) throws Exception {
		return Result.success();
	}
}
