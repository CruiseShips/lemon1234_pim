package com.lemon1234.sys.result;

import io.jsonwebtoken.Claims;

/**
 * Jwt 信息返回
 * 
 * @date 2021年1月19日
 * @author lemon1234.zhihua
 */
public class JwtResult {

	private Integer errCode;

    private boolean success;

    private Claims claims;

	public Integer getErrCode() {
		return errCode;
	}

	public void setErrCode(Integer errCode) {
		this.errCode = errCode;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Claims getClaims() {
		return claims;
	}

	public void setClaims(Claims claims) {
		this.claims = claims;
	}
    
}
