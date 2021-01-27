package com.lemon1234.entity;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 和主账号相关的一些关联账号，比如邮箱账号有什么授权码等我们可以单独定义进行存储
 */
@ApiModel("账号的附属账号")
public class Additional {

	@ApiModelProperty("主键id")
	private String id;
	
	@ApiModelProperty("主体账号id")
	private String accountId;
	
	@ApiModelProperty("自定义含义")
	private String diyKey;
	
	@ApiModelProperty("密码")
	private String password;
	
	@ApiModelProperty("创建日期")
	private Date createDt;
}
