package com.lemon1234.service;

import java.util.Map;

import com.lemon1234.entity.dto.QueryBankListDTO;

/**
 * 账号仓库接口
 */
public interface BankService {

	Map<String, Object> queryBankList(QueryBankListDTO dto) throws Exception;
}
