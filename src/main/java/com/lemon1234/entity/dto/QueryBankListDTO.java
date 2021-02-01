package com.lemon1234.entity.dto;

import com.lemon1234.entity.sys.BaseDTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("查询用户账号仓库DTO")
public class QueryBankListDTO extends BaseDTO {

	@ApiModelProperty("用户姓名")
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
}
