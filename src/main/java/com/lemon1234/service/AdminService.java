package com.lemon1234.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lemon1234.entity.dto.GetAdminListDTO;
import com.lemon1234.entity.vo.GetAdminListVO;

/**
 * Admin 接口
 */
public interface AdminService extends UserDetailsService {

	Page<GetAdminListVO> getAdminList(GetAdminListDTO dto) throws Exception;
}
