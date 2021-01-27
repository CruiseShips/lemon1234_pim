package com.lemon1234.entity;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("上传的文件")
public class UploadFile {

	@ApiModelProperty("主键id")
	private String id;
	
	@ApiModelProperty("用户id")
	private String userId;
	
	@ApiModelProperty("文件名称")
	private String fileName;
	
	@ApiModelProperty("创建日期")
	private String createDt;
	
	@ApiModelProperty("文件大小")
	private BigDecimal size;
	
}
