package com.lemon1234.provider;

public class RoleProvider {

	public String selectRoleByUserId(String id) throws Exception {
		StringBuffer sBuffer = new StringBuffer();
		
		sBuffer.append("SELECT role.* FROM t_pim_role role ");
		sBuffer.append("LEFT JOIN t_pim_admin_role p ON p.roleId = role.id ");
		sBuffer.append("WHERE p.id = '${id}' ");
		
		return sBuffer.toString();
	}
}
