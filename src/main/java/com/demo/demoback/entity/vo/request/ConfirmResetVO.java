package com.demo.demoback.entity.vo.request;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

/**
 * @Author LHF
 * @Date 2024:03:20:22:01
 **/
@Data
@AllArgsConstructor
@Accessors(chain = true)
public class ConfirmResetVO {

    @Email
    private String email;
    @Length(max = 6, min = 6)
    private String code;
}
