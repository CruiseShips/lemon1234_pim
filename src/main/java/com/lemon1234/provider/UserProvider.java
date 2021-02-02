package com.lemon1234.provider;

import com.lemon1234.util.StringUtil;

public class UserProvider {

	public String getUserList(String username) throws Exception {
		StringBuffer sBuffer = new StringBuffer();
		sBuffer.append("SELECT ");
		sBuffer.append("id AS userId, ");
		sBuffer.append("name AS username ");
		sBuffer.append("FROM t_pim_user ");
		if(StringUtil.isNotEmpty(username)) {
			sBuffer.append("WHERE name like '%" + username + "%'");
		}
		return sBuffer.toString();
	}
	
	public String getUserCount(String username) throws Exception {
		StringBuffer sBuffer = new StringBuffer();
		sBuffer.append("SELECT ");
		sBuffer.append("COUNT(1) ");
		sBuffer.append("FROM t_pim_user ");
		if(StringUtil.isNotEmpty(username)) {
			sBuffer.append("WHERE name like '%" + username + "%'");
		}
		return sBuffer.toString();
	}
}
