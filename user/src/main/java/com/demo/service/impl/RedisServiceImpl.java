package com.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.demo.baomidou.entity.UserInfo;
import com.demo.baomidou.service.UserInfoService;
import com.demo.service.IRedisService;
import entity.ResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author 9527
 * @version 1.0
 * @date 2020-12-21 10:40
 */
@Service
public class RedisServiceImpl implements IRedisService {

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    UserInfoService userInfoServiceImpl;


    @Override
    public ResultDto redisTest(UserInfo entity) {
        //
        QueryWrapper<UserInfo> qw =  new QueryWrapper<>();
       // qw.eq("phone",entity.getPhone());
        qw.eq("delete_mark",0);
        qw.last("limit 1");

        //根据手机号查询当前数据是否存在,不存在则插入,存在则更新
        UserInfo one = userInfoServiceImpl.getOne(qw);
        if (null == one ){
           userInfoServiceImpl.save(entity);


        }


        System.out.println(one);
        return null;
    }
}
