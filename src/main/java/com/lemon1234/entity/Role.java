package com.lemon1234.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("权限")
public class Role {

	@ApiModelProperty("主键id")
	private String id;
	
	@ApiModelProperty("中文名称")
	private String name;
	
	@ApiModelProperty("英文名称")
	private String engName;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEngName() {
		return engName;
	}

	public void setEngName(String engName) {
		this.engName = engName;
	}
	
}
