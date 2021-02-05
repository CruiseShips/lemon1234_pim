package com.lemon1234.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lemon1234.entity.Admin;
import com.lemon1234.entity.dto.AddManageDTO;
import com.lemon1234.entity.dto.GetManageListDTO;

/**
 * Admin 接口
 */
public interface AdminService extends UserDetailsService {

	Page<Admin> getAdminList(GetManageListDTO dto) throws Exception;

	Integer addManage(AddManageDTO dto) throws Exception;

	Integer banAdmin(String id) throws Exception;
	
	Integer resetPassword(String id) throws Exception;
}
