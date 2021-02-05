package com.lemon1234.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lemon1234.entity.Admin;
import com.lemon1234.entity.dto.GetAdminListDTO;

/**
 * Admin 接口
 */
public interface AdminService extends UserDetailsService {

	Page<Admin> getAdminList(GetAdminListDTO dto) throws Exception;
}
