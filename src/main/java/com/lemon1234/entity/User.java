package com.lemon1234.entity;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("用户")
public class User {

	@ApiModelProperty("主键id")
	private String id;
	
	@ApiModelProperty("昵称")
	private String name;
	
	@ApiModelProperty("创建时间")
	private Date createDt;
	
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
	
	// ON OFF
	@ApiModelProperty("封禁")
	private String ban;
	
	// 二级密码
	@ApiModelProperty("二级密码")
	private String sercet;
	
	@ApiModelProperty("盐")
	private String salt;
	
	// 会员无上限
	// 非会员有 512M
	@ApiModelProperty("存储空间使用大小（RAS秘钥、导出文件等）")
	private Integer spaceSize;
	
	// 10 块钱永久
	@ApiModelProperty("是否是会员")
	private Integer isMembers;

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

	public String getSercet() {
		return sercet;
	}

	public void setSercet(String sercet) {
		this.sercet = sercet;
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

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getBan() {
		return ban;
	}

	public void setBan(String ban) {
		this.ban = ban;
	}
	
}
