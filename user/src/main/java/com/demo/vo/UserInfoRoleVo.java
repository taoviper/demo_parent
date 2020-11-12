package com.demo.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author 9527
 * @version 1.0
 * @date 2020-11-2 15:39
 */
@Data
public class UserInfoRoleVo extends  BasePage{

    private String username;

    private Integer age;

    private Integer sex;

    private String roleName;

    private Date createTime;

}
