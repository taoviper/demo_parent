package com.demo.controller;

import com.demo.baomidou.entity.UserInfo;
import com.demo.service.impl.RedisServiceImpl;
import entity.ResultDto;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 9527
 * @version 1.0
 * @date 2020-12-21 10:26
 */
@Api(tags = "测试redis缓存")
@RestController
@RequestMapping("/api/cache")
public class RedisTestController {


    private static final Logger logger = LoggerFactory.getLogger(RedisTestController.class);

    @Autowired
    RedisServiceImpl redisServiceImpl;
    /**
     * 测试缓存
     * @param entity 123
     * @return 123
     */
    @PostMapping(value = "/storage")
    private ResultDto redisTest(UserInfo entity){
        return redisServiceImpl.redisTest(entity);
    }

}
