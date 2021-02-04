package com.lemon1234.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lemon1234.entity.Bank;
import com.lemon1234.entity.vo.QueryBankInfoListVO;
import com.lemon1234.entity.vo.QueryBankListVO;

import io.lettuce.core.dynamic.annotation.Param;

@Mapper
public interface BankMapper extends BaseMapper<Bank> {

	@Select(value = "SELECT * FROM t_pim_bank WHERE userId = #{userId}")
	List<QueryBankListVO.DTO> queryBankList(@Param(value = "userId")String userId) throws Exception;
	
	@Select(value = "SELECT id, `name`, `describe`, createDt FROM t_pim_bank WHERE userId = #{userId} ORDER BY createDt DESC")
	List<QueryBankInfoListVO> queryBankInfoList(@Param(value = "userId")String userId) throws Exception;
}
