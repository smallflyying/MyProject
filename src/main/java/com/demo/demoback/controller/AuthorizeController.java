package com.demo.demoback.controller;

import com.demo.demoback.entity.RestBean;
import com.demo.demoback.entity.vo.request.ConfirmResetVO;
import com.demo.demoback.entity.vo.request.EmailRegisterVo;
import com.demo.demoback.entity.vo.request.EmailResetVO;
import com.demo.demoback.service.AccountService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @Author LHF
 * @Date 2024:03:19:21:47
 **/
@Validated
@RestController
@RequestMapping("/api/auth")
public class AuthorizeController {

    @Autowired
    private AccountService service;

    @GetMapping("/ask-code")
    public RestBean<Void> askVerifyCode(@RequestParam @Email String email,
                                        @RequestParam @Pattern(regexp = "(register|reset)") String type,
                                        HttpServletRequest request) {
        return this.messageHandle(() ->
                service.registerEmailVerifyCode(type,email,request.getRemoteAddr()));
    }

    @PostMapping("/register")
    public RestBean<Void> register(@RequestBody @Valid EmailRegisterVo vo) {
        return this.messageHandle(vo,service::registerEmailAccount);
    }

    @PostMapping("/reset-confirm")
    public RestBean<Void> resetConfirm(@RequestBody @Valid ConfirmResetVO vo) {
        return this.messageHandle(vo,service::resetConfirm);
    }

    @PostMapping("/resetPassword")
    public RestBean<Void> resetPassword(@RequestBody @Valid EmailResetVO vo) {
        return this.messageHandle(vo,service::resetAccountPassword);
    }

    private <T> RestBean<Void> messageHandle(T vo, Function<T, String> function) {
        return messageHandle(() -> function.apply(vo));
    }

    private RestBean<Void> messageHandle(Supplier<String> action) {
        String message = action.get();
        return message == null ? RestBean.success() : RestBean.failure(400, message);
    }
}
