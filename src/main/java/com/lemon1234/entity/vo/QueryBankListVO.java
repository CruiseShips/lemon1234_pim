package com.lemon1234.entity.vo;

import java.util.Date;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("查询用户账号仓库VO")
public class QueryBankListVO {

	@ApiModelProperty("用户id")
	private String userId;
	
	@ApiModelProperty("昵称")
	private String username;
	
	@ApiModelProperty("账号仓库集合")
	private List<DTO> bankDTO;
	
	@ApiModel("账号仓库")
	public static class DTO {
		
		@ApiModelProperty("主键id")
		private String id;
		
		@ApiModelProperty("账号库名称")
		private String name;
		
		@ApiModelProperty("描述")
		private String describe;
		
		@ApiModelProperty("创建日期")
		private Date createDt;
		
		@ApiModelProperty()
		private Integer accountCount;

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

		public Integer getAccountCount() {
			return accountCount;
		}

		public void setAccountCount(Integer accountCount) {
			this.accountCount = accountCount;
		}
		
	}
	
	@ApiModelProperty("账号仓库个数")
	private Integer bankAll;
	
	@ApiModelProperty("总账号数量")
	private Integer accountAll;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<DTO> getBankDTO() {
		return bankDTO;
	}

	public void setBankDTO(List<DTO> bankDTO) {
		this.bankDTO = bankDTO;
	}

	public Integer getBankAll() {
		return bankAll;
	}

	public void setBankAll(Integer bankAll) {
		this.bankAll = bankAll;
	}

	public Integer getAccountAll() {
		return accountAll;
	}

	public void setAccountAll(Integer accountAll) {
		this.accountAll = accountAll;
	}
	
}
