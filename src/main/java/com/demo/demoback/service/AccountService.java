package com.demo.demoback.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.demoback.entity.dto.Account;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @Author LHF
 * @Date 2024:03:18:22:39
 **/
public interface AccountService extends IService<Account>, UserDetailsService {

    public Account findAccountByNameOrEmail(String text);

    public String registerEmailVerifyCode(String type, String email, String ip);
}
