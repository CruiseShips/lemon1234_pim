package com.lemon1234.controller.admin;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lemon1234.sys.result.Result;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "{管理端-用户账号模块}")
@RestController
@RequestMapping("/admin/bank")
public class BankAdminController {

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@ApiOperation(value = "查询所有用户所拥有的账号仓库", notes = "需要有管理员权限", httpMethod = "POST")
	@PostMapping("/queryBankList")
	public Result queryBankList() throws Exception {
		
		return Result.success();
	}
}
