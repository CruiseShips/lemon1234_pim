package com.lemon1234.controller.admin;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lemon1234.entity.dto.QueryBankListDTO;
import com.lemon1234.entity.vo.QueryBankInfoListVO;
import com.lemon1234.service.BankService;
import com.lemon1234.sys.result.Result;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "{管理端-用户账号库模块}")
@RestController
@RequestMapping("/admin/bank")
public class BankAdminController {
	
	@Autowired
	private BankService bankService;

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@ApiOperation(value = "查询所有用户所拥有的账号仓库", notes = "需要有管理员权限", httpMethod = "POST")
	@PostMapping("/queryBankList")
	public Result queryBankList(@RequestBody QueryBankListDTO dto) throws Exception {
		Map<String, Object> voList = bankService.queryBankList(dto);
		return Result.success(voList);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@ApiOperation(value = "查询所有用户所拥有的账号仓库详情", notes = "需要有管理员权限", httpMethod = "GET")
	@GetMapping("/queryBankInfoList")
	public Result queryBankInfoList(@RequestParam(value = "userId")String userId) throws Exception {
		List<QueryBankInfoListVO> resultList = bankService.queryBankInfoList(userId);
		return Result.success(resultList);
	}
}
