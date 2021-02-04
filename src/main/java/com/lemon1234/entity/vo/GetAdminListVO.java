package com.lemon1234.entity.vo;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("系统管理员类")
public class GetAdminListVO {

	@ApiModelProperty("主键id")
	private String id;
	
	@ApiModelProperty("账号")
	private String username;
	
	@ApiModelProperty("密码")
	private String password;
	
	@ApiModelProperty("创建时间")
	private Date createDt;
	
	@ApiModelProperty("邮箱")
	private String email;
	
	@ApiModelProperty("手机号")
	private String phoneNum;
	
	@ApiModelProperty("性别")
	private Integer gender;
	
	@ApiModelProperty("昵称")
	private String name;
	
	@ApiModelProperty("头像")
	private String img;
	
	// ON OFF
	@ApiModelProperty("封禁")
	private String ban;
	
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getBan() {
		return ban;
	}

	public void setBan(String ban) {
		this.ban = ban;
	}
	
}
