package com.demo.demoback.entity.vo.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

/**
 * @Author LHF
 * @Date 2024:03:20:21:00
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class EmailRegisterVo {

    @Email
    private String email;
    @Length(max = 6, min = 6)
    private String code;
    @Pattern(regexp = "^[a-zA-Z0-9\\u4e00-\\u9fa5]+$")
    @Length(min = 1, max = 10)
    private String username;
    @Length(min = 6, max = 20)
    private String password;
}
