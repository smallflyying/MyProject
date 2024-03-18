package com.demo.demoback.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.demoback.entity.dto.Account;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author LHF
 * @Date 2024:03:18:22:38
 **/
@Mapper
public interface AccountMapper extends BaseMapper<Account> {
}
