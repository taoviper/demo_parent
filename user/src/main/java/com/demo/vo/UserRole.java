package com.demo.vo;

import lombok.Data;

/**
 * @author 9527
 * @version 1.0
 * @date 2020-11-2 15:20
 */
@Data
public class UserRole {

    /**
     * 角色id
     */
    private int roleId;

    /**
     * 角色名(  0,打工人;1,将军;2,总统; )
     */
    private String roleName;
}
