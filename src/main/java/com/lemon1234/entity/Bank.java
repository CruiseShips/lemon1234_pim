package com.lemon1234.entity;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

// 公司库、个人库、QQ账号库、游戏库等~~
@ApiModel("账号库")
public class Bank {

	@ApiModelProperty("主键id")
	private String id;
	
	@ApiModelProperty("用户id")
	private String userId;
	
	@ApiModelProperty("账号库名称")
	private String name;
	
	@ApiModelProperty("描述")
	private String describe;
	
	@ApiModelProperty("创建日期")
	private Date createDt;
}
