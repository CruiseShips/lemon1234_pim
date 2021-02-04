package com.lemon1234.service;

import java.util.List;
import java.util.Map;

import com.lemon1234.entity.dto.QueryBankListDTO;
import com.lemon1234.entity.vo.QueryBankInfoListVO;

/**
 * 账号仓库接口
 */
public interface BankService {

	Map<String, Object> queryBankList(QueryBankListDTO dto) throws Exception;
	
	List<QueryBankInfoListVO> queryBankInfoList(String userId) throws Exception;
}
