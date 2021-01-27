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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getUpdateDt() {
		return updateDt;
	}

	public void setUpdateDt(Date updateDt) {
		this.updateDt = updateDt;
	}

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}
	
}
