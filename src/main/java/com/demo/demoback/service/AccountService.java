package com.demo.demoback.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.demoback.entity.dto.Account;
import com.demo.demoback.entity.vo.request.ConfirmResetVO;
import com.demo.demoback.entity.vo.request.EmailRegisterVo;
import com.demo.demoback.entity.vo.request.EmailResetVO;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @Author LHF
 * @Date 2024:03:18:22:39
 **/
public interface AccountService extends IService<Account>, UserDetailsService {

    public Account findAccountByNameOrEmail(String text);
    public String registerEmailVerifyCode(String type, String email, String ip);

    public String registerEmailAccount(EmailRegisterVo vo);

    public String resetConfirm(ConfirmResetVO vo);
    public String resetAccountPassword(EmailResetVO vo);
}
