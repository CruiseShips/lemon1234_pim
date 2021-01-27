package com.lemon1234.entity;

import java.math.BigDecimal;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("用户")
public class User {

	@ApiModelProperty("主键id")
	private String id;
	
	@ApiModelProperty("昵称")
	private String name;
	
	@ApiModelProperty("邮箱")
	private String email;
	
	@ApiModelProperty("手机号")
	private String phoneNum;
	
	@ApiModelProperty("openId")
	private String openId;
	
	// 0 未知，1男，2女
	@ApiModelProperty("性别")
	private Integer gender;
	
	// 微信头像
	@ApiModelProperty("头像")
	private String photo;
	
	@ApiModelProperty("创建时间")
	private Date createDt;
	
	// 二级密码
	@ApiModelProperty("二级密码")
	private String sercet;
	
	// 系统生成
	// 可以自己设定，可以系统生成
	@ApiModelProperty("盐")
	private String salt;
	
	@ApiModelProperty("已经使用的空间大小")
	private BigDecimal spaceSize;
	
	// 1000kb
	// 10 块钱永久使用
	@ApiModelProperty("是否是会员")
	private Integer isMembers;
	
}
