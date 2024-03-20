package com.demo.demoback.controller.exception;

import com.demo.demoback.entity.RestBean;
import jakarta.validation.ValidationException;
import jakarta.validation.constraints.Email;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author LHF
 * @Date 2024:03:20:20:54
 **/
@Slf4j
@RestControllerAdvice
public class ValidationController {

    @ExceptionHandler(ValidationException.class)
    public RestBean<Void> validateException(ValidationException exception) {
        log.warn("Resolve [{}: {}]", exception.getClass().getName(),exception.getMessage());
        return RestBean.failure(400,"请求参数有误");
    }
}
