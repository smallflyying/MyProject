package com.demo.demoback.entity.vo.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @Author LHF
 * @Date 2024:03:17:21:28
 **/
@Data
@Accessors(chain = true)
public class LoginResp {
    private String username;
    private String userRole;
    private String token;
    private Date expire;

}
