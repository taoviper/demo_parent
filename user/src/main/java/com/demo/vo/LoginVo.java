package com.demo.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author 9527
 * @version 1.0
 * @date 2020-10-29 15:16
 */
@Data
public class LoginVo {

//    @NotNull(message = "手机号不能为空")
//    private String phone;

    @NotNull(message = "密码不能为空")
    private String password;

    @NotNull(message = "用户名不能为空")
    private String username;
}
