package com.lemon1234.entity;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("具体账号")
public class Account {

	@ApiModelProperty("主键id")
	private String id;
	
	@ApiModelProperty("对应库id")
	private String bankId;
	
	@ApiModelProperty("账号名称")
	private String name;
	
	@ApiModelProperty("账号")
	private String account;
	
	@ApiModelProperty("密码")
	private String password;
	
	@ApiModelProperty("创建日期")
	private Date createDt;
	
	@ApiModelProperty("最后更新时间")
	private Date lastUpdateDt;
	
	@ApiModelProperty("查看次数")
	private Integer viewNum;
	
	@ApiModelProperty("链接")
	private String connection;
	
	@ApiModelProperty("现在使用的RSA加密文件id")
	private String fileId;
}
