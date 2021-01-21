package com.lemon1234.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("查看所有角色DTO")
public class QueryUserListDTO {

	@ApiModelProperty("封禁")
	private String phone;
	
	@ApiModelProperty("封禁")
	private String ban;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBan() {
		return ban;
	}

	public void setBan(String ban) {
		this.ban = ban;
	}
	
}
