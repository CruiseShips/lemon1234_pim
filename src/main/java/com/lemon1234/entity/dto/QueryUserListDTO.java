package com.lemon1234.entity.dto;

import com.lemon1234.entity.sys.BaseDTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("查看所有用户DTO")
public class QueryUserListDTO extends BaseDTO {

	@ApiModelProperty("用户昵称")
	private String name;
	
	@ApiModelProperty("用户手机号")
	private String phoneNum;

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
