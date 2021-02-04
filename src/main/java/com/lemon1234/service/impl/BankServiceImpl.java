package com.lemon1234.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lemon1234.entity.User;
import com.lemon1234.entity.dto.QueryBankListDTO;
import com.lemon1234.entity.vo.QueryBankInfoListVO;
import com.lemon1234.entity.vo.QueryBankListVO;
import com.lemon1234.mapper.BankMapper;
import com.lemon1234.mapper.UserMapper;
import com.lemon1234.service.AccountService;
import com.lemon1234.service.BankService;
import com.lemon1234.util.StringUtil;

@Transactional
@Service("bankService")
public class BankServiceImpl implements BankService {

	@Autowired
	private BankMapper bankMapper;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private AccountService accountService;

	@Override
	public Map<String, Object> queryBankList(QueryBankListDTO dto) throws Exception {
		Page<User> userPage = new Page<User>((dto.getCurrentPage()-1)*dto.getPageSize(), dto.getPageSize());
		
		List<QueryBankListVO> voList = userMapper.getUserList(dto.getUsername(), userPage);
		Integer count = userMapper.getUserCount(dto.getUsername());
		
		voList.stream().forEach(e -> {
			List<QueryBankListVO.DTO> dtos;
			try {
				dtos = bankMapper.queryBankList(e.getUserId());
				e.setBankDTO(dtos);
				e.setBankAll(dtos.size());
				try {
					e.setAccountAll(this.getAccountCount(dtos));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		});
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("data", voList);
		resultMap.put("count", count);
		return resultMap;
	}
	
	@Override
	public List<QueryBankInfoListVO> queryBankInfoList(String userId) throws Exception {
		if (StringUtil.isEmpty(userId)) {
			return null;
		}
		
		List<QueryBankInfoListVO> voList = bankMapper.queryBankInfoList(userId);
		
		return voList;
	}
	
	private Integer getAccountCount(List<QueryBankListVO.DTO> dtos) throws Exception {
		int count = 0;
		for(QueryBankListVO.DTO dto: dtos) {
			count += accountService.getAccountCountByBankId(dto.getId());
		};
		return count;
	}
	
}
