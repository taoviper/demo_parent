package com.demo.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author 9527
 * @version 1.0
 * @date 2020-10-27 9:36
 */
@Data
public class UserInfo {

    private String uuid;

    private String username;

    private String phone;

    private int sex;

    private int age;

    private String password;

    private Date createTime;

    private Date updateTime;

    private int deleteMark;

}
