package com.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.vo.UserInfo;

/**
 * @author 9527
 * @version 1.0
 * @date 2020-10-27 10:01
 */
public interface IUserInfoService extends IService<UserInfo> {

    /**
     * 新增
     * @param userInfo req
     * @return boolean
     */
    boolean addUserInfo(UserInfo userInfo);

    /**
     * 获取短信验证码
     * @param phone 手机号
     */
    void getMessageCode(String phone);

}
