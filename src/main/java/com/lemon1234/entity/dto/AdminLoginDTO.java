package com.lemon1234.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("登录请求对象")
public class AdminLoginDTO {

	@ApiModelProperty(value = "账号", required = true)
	private String username;
	
	@ApiModelProperty(value = "密码", required = true)
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "AdminLoginDTO [username=" + username + ", password=" + password + "]";
	}
	
}
