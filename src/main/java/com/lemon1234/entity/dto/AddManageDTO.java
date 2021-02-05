package com.lemon1234.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("添加管理员DTO")
public class AddManageDTO {

	@ApiModelProperty(value = "账号", required = true)
	private String username;
	
	@ApiModelProperty(value = "邮箱", required = true)
	private String email;
	
	@ApiModelProperty(value = "手机号", required = true)
	private String phoneNum;
	
	@ApiModelProperty("性别")
	private Integer gender;
	
	@ApiModelProperty(value = "昵称", required = true)
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

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
