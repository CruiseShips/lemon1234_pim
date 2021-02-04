package com.lemon1234.entity.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("查询用户账号仓库具体信息vo")
public class QueryBankInfoListVO {
	
	@ApiModelProperty("主键id")
	private String id;

	@ApiModelProperty("账号库名称")
	private String name;
	
	@ApiModelProperty("描述")
	private String describe;
	
	@ApiModelProperty("创建日期")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date createDt;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public Date getCreateDt() {
		return createDt;
	}

	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
