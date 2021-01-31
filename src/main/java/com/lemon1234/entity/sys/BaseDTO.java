package com.lemon1234.entity.sys;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("系统分页请求参数")
public class BaseDTO {

	@ApiModelProperty("开始页面")
	private Integer currentPage;
	
	@ApiModelProperty("数据大小")
	private Integer pageSize;
	
	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
}
