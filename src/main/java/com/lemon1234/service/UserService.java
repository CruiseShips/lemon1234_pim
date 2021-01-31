package com.lemon1234.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lemon1234.entity.User;
import com.lemon1234.entity.dto.QueryUserListDTO;

public interface UserService {

	Page<User> queryUserList(QueryUserListDTO dto) throws Exception;
}
