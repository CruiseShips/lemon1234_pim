package com.lemon1234.provider;

import com.lemon1234.entity.dto.GetAdminListDTO;
import com.lemon1234.util.StringUtil;

public class AdminProvider {

	public String loadUserByUsername(String username) {
		return "SELECT * FROM t_pim_admin WHERE username = #{username}";
	}
	
	public String getAdminList(GetAdminListDTO dto) {
		StringBuffer sBuffer = new StringBuffer();
		sBuffer.append("SELECT * FROM t_pim_admin WHERE 1=1 ");
		if(StringUtil.isNotEmpty(dto.getName())) {
			sBuffer.append("AND name like CONCAT('%', #{dto.name}, '%')");
		}
		if(StringUtil.isNotEmpty(dto.getUsername())) {
			sBuffer.append("AND username = #{dto.username} ");
		}
		if(StringUtil.isNotEmpty(dto.getEmail())) {
			sBuffer.append("AND email = #{dto.email} ");
		}
		if(StringUtil.isNotEmpty(dto.getPhoneNum())) {
			sBuffer.append("AND phoneNum = #{dto.phoneNum} ");
		}
		
		return sBuffer.toString();
	}
}
