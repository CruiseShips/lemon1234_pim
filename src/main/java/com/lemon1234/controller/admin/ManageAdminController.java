package com.lemon1234.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lemon1234.entity.Admin;
import com.lemon1234.entity.dto.AddManageDTO;
import com.lemon1234.entity.dto.GetManageListDTO;
import com.lemon1234.service.AdminService;
import com.lemon1234.sys.result.Result;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "{管理端-管理员管理模块}")
@RestController
@RequestMapping("/admin/manage")
public class ManageAdminController {
	
	@Autowired
	private AdminService adminService;

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@ApiOperation(value = "查询所有系统管理员", notes = "查看可以都去查看，但是管理员不能查看到系统最高管理员", httpMethod = "POST")
	@PostMapping("/getManageList")
	public Result getManageList(@RequestBody GetManageListDTO dto) throws Exception {
		Page<Admin> adminPage = adminService.getAdminList(dto);
		return Result.success(adminPage);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@ApiOperation(value = "添加管理员", notes = "需要有管理员权限", httpMethod = "POST")
	@PostMapping("/addManage")
	public Result addManage(@RequestBody AddManageDTO dto) throws Exception {
		Integer operand = adminService.addManage(dto);
		if(operand > 0) {
			return Result.success("添加成功");
		}
		return Result.error("添加失败");
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@ApiOperation(value = "封禁管理员", notes = "需要有管理员权限", httpMethod = "GET")
	@GetMapping("/banAdmin")
	public Result banAdmin(@RequestParam(value = "id", required = true) String id) throws Exception {
		Integer operand = adminService.banAdmin(id);
		if(operand < 0) {
			return Result.error("无法找到该用户");
		} else {
			return Result.success("修改成功");
		}
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@ApiOperation(value = "重置密码", notes = "需要有管理员权限", httpMethod = "GET")
	@GetMapping("/resetPassword")
	public Result resetPassword(@RequestParam(value = "id", required = true) String id) throws Exception {
		Integer operand = adminService.resetPassword(id);
		if(operand < 0) {
			return Result.error("无法找到该用户");
		} else {
			return Result.success();
		}
	}
}
