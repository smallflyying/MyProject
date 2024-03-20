package com.demo.demoback.entity.vo.request;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

/**
 * @Author LHF
 * @Date 2024:03:20:22:04
 **/
@Data
@AllArgsConstructor
@Accessors(chain = true)
public class EmailResetVO {

    @Email
    private String email;
    @Length(max = 6, min = 6)
    private String code;
    @Length(min = 5, max = 20)
    private String password;
}
