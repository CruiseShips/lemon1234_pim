package com.lemon1234.entity.dto;

import com.lemon1234.entity.sys.BaseDTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("获取管理员集合DTO")
public class GetAdminListDTO extends BaseDTO {

	@ApiModelProperty("账号")
	private String username;
	
	@ApiModelProperty("邮箱")
	private String email;
	
	@ApiModelProperty("手机号")
	private String phoneNum;
	
	@ApiModelProperty("昵称")
	private String name;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

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
