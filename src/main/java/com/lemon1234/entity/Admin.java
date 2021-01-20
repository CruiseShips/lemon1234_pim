package com.lemon1234.entity;

import java.util.Collection;
import java.util.Date;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.lemon1234.entity.dict.Constants;
import com.lemon1234.util.StringUtil;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 系统管理员类
 */
@ApiModel
public class Admin implements UserDetails {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty("主键id")
	private String id;
	
	@ApiModelProperty("账号")
	private String account;
	
	@ApiModelProperty("密码")
	private String password;
	
	@ApiModelProperty("创建时间")
	private Date createDt;
	
	@ApiModelProperty("邮箱")
	private String email;
	
	@ApiModelProperty("手机号")
	private String phoneNum;
	
	@ApiModelProperty("性别")
	private String gender;
	
	@ApiModelProperty("昵称")
	private String name;
	
	@ApiModelProperty("头像")
	private String img;
	
	// ON OFF
	@ApiModelProperty("封禁")
	private String ban;
	
	@ApiModelProperty("用户权限")
	private Collection<GrantedAuthority> authorities;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return account;
	}

	// 账户是否过期
	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	// 账户是否被锁定
	@Override
	public boolean isAccountNonLocked() {
		return false;
	}

	// 证书是否过期
	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}

	/**
	 * 如果是空或者是OFF，直接返回false，表示无效账户
	 */
	@Override
	public boolean isEnabled() {
		if(StringUtil.isEmpty(ban)) {
			return false;
		}
		if(ban.equals(Constants.OFF)) {
			return false;
		}	
		return true;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
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

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAuthorities(Collection<GrantedAuthority> authorities) {
		this.authorities = authorities;
	}
	
}
