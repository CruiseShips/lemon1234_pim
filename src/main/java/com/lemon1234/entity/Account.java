package com.lemon1234.entity;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("具体账号")
public class Account implements Serializable {

	private static final long serialVersionUID = 1L;

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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBankId() {
		return bankId;
	}

	public void setBankId(String bankId) {
		this.bankId = bankId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Date getCreateDt() {
		return createDt;
	}

	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}

	public Date getLastUpdateDt() {
		return lastUpdateDt;
	}

	public void setLastUpdateDt(Date lastUpdateDt) {
		this.lastUpdateDt = lastUpdateDt;
	}

	public Integer getViewNum() {
		return viewNum;
	}

	public void setViewNum(Integer viewNum) {
		this.viewNum = viewNum;
	}

	public String getConnection() {
		return connection;
	}

	public void setConnection(String connection) {
		this.connection = connection;
	}

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}
	
}
