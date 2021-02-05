package com.lemon1234.provider;

import com.lemon1234.entity.dto.GetAdminListDTO;
import com.lemon1234.util.StringUtil;

public class AdminProvider {

	public String loadUserByUsername(String username) {
		return "SELECT * FROM t_pim_admin WHERE username = #{username}";
	}
}
