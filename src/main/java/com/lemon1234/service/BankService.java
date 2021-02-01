package com.lemon1234.service;

import java.util.List;

import com.lemon1234.entity.dto.QueryBankListDTO;
import com.lemon1234.entity.vo.QueryBankListVO;

/**
 * 账号仓库接口
 */
public interface BankService {

	List<QueryBankListVO> queryBankList(QueryBankListDTO dto) throws Exception;
}
