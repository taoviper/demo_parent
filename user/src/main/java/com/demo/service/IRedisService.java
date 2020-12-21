package com.demo.service;


import com.demo.baomidou.entity.UserInfo;
import entity.ResultDto;

/**
 * @author 9527
 * @version 1.0
 * @date 2020-12-21 10:32
 */
public interface IRedisService {

    ResultDto redisTest(UserInfo entity);

}
