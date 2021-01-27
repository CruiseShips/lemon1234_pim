package com.lemon1234.entity;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("系统通知")
public class SysNotice {

	@ApiModelProperty("主键id")
	private String id;
	
	@ApiModelProperty("标题")
	private String title;
	
	@ApiModelProperty("内容")
	private String context;
	
	@ApiModelProperty("通知日期")
	private Date sendDt;
	
	// 0 未查看，1查看
	@ApiModelProperty("查看次数")
	private Integer seeCount;
	
}
