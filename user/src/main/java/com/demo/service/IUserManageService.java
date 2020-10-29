package com.demo.service;

import com.demo.vo.LoginVo;
import com.demo.vo.UserInfo;
import entity.ResultDto;

/**
 * @author 9527
 * @version 1.0
 * @date 2020-10-29 9:28
 */
public interface IUserManageService {

    /**
     * 新增用户
     * @param req 实体
     * @return 结果状态
     */
    ResultDto addUserInfo(UserInfo req);


    /**
     * 获取用户手机验证码
     * @param phone  手机号
     * @return 结果集
     */
    ResultDto getMessageCode(String phone);

    /**
     * 校验登录
     * @param req 请求参数
     * @return 结果集
     */
    ResultDto login(LoginVo req);
}
