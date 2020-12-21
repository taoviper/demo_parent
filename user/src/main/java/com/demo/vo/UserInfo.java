package com.demo.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;


import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author 9527
 * @version 1.0
 * @date 2020-10-27 9:36
 */
//@Data
//public class UserInfo  {
//
//    private String uuid;
//
//    @NotNull(message = "用户名不能为空")
//    private String username;
//
//    @NotNull(message = "手机号不能为空")
//    private String phone;
//
//    private int sex;
//
//    private int age;
//
//    @NotNull(message = "密码不能为空")
//    private String password;
//
//    private Date createTime;
//
//    private Date updateTime;
//
//    private int deleteMark;
//
//    private int roleId;
//
////    //数据库不需要的字段 还可以使用注解  @Transient
//    @TableField(exist = false)
//    private String messageCode;
//}
