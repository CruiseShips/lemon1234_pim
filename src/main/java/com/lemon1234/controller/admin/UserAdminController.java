package com.lemon1234.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lemon1234.entity.User;
import com.lemon1234.entity.dto.QueryUserListDTO;
import com.lemon1234.service.UserService;
import com.lemon1234.sys.result.Result;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 用户后端请求类
 */
@Api(tags = "{管理端-用户模块}")
@RestController
@RequestMapping("/admin/user")
public class UserAdminController {
	
	@Autowired
	private UserService userService;
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@ApiOperation(value = "查询所有用户", notes = "需要有管理员权限", httpMethod = "POST")
	@PostMapping("/queryUserList")
	public Result queryUserList(@RequestBody QueryUserListDTO dto) throws Exception {
		Page<User> userPage = userService.queryUserList(dto);
		return Result.success(userPage);
	}
}
