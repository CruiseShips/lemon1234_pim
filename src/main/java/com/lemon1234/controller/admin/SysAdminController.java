package com.lemon1234.controller.admin;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lemon1234.entity.dto.LoginDTO;
import com.lemon1234.sys.result.Result;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "{管理端-系统模块}")
@RestController
@RequestMapping("/admin")
public class SysAdminController {
	
	@ApiOperation(value = "系统用户登录", notes = "不需要任何权限", httpMethod = "POST")
	@PostMapping("/login")
	public Result login(@RequestBody LoginDTO dto) throws Exception {
		
		return Result.success();
	}
}
