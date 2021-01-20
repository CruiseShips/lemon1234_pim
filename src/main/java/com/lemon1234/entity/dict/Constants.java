package com.lemon1234.entity.dict;

public class Constants {
	
	// RSA 公钥私钥
	// 公钥
	public static final String RSA_PUBLIC_KEY = "001";
	// 私钥
	public static final String RSA_PRIVATE_KEY = "002";

	
	// 系统返回状态
	public static final Integer HTTP_200 = 200;
	public static final Integer HTTP_500 = 500;
	
	// Jwt token 状态返回
	public static final Integer JWT_ERRCODE_NULL = 4000;
	public static final Integer JWT_ERRCODE_EXPIRE = 4001;
	public static final Integer JWT_ERRCODE_FAIL = 4002;
	
	// 账号封禁
	// ON 正常
	public static final String ON = "ON";
	// OFF 不正常
	public static final String OFF = "OFF";
	
}
