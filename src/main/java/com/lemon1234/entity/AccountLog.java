package com.lemon1234.entity;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("账号记录表")
public class AccountLog {

	@ApiModelProperty("主键id")
	private String id;
	
	@ApiModelProperty("原账号id")
	private String accountId;
	
	@ApiModelProperty("账号")
	private String account;
	
	@ApiModelProperty("密码")
	private String password;
	
	@ApiModelProperty("更改日期")
	private Date updateDt;
	
	@ApiModelProperty("曾经使用的RSA加密文件id")
	private String fileId;
}
