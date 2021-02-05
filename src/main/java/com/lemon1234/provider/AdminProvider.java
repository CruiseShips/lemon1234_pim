package com.lemon1234.provider;

public class AdminProvider {

	public String loadUserByUsername(String username) {
		return "SELECT * FROM t_pim_admin WHERE username = #{username}";
	}
}
