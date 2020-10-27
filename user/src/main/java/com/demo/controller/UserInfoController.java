package com.demo.controller;

import com.demo.utils.RandomCode;
import entity.ResultDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 9527
 * @version 1.0
 * @date 2020-10-27 9:44
 */
@Api(tags = "用户模块")
@RestController
@RequestMapping("/api/userInfo")
public class UserInfoController {

    private static final Logger logger = LoggerFactory.getLogger(UserInfoController.class);

    /**
     * 获取短信验证码
     * @param phone 手机号
     */
    @ApiOperation(value = "获取短信验证码",notes = "多学习")
    @PostMapping("/messageCode/{phone}")
    private void getMessageCode(@PathVariable @ApiParam String phone){
        logger.info("start UserInfoController getMessageCode start,param:{}",phone);
        //01生成随机的六位数验证码

        //02存入redis

        //03使用消息中间件消费

    }

    /**
     * 获取短信验证码
     *
     */
    @ApiOperation(value = "测试swagger2是否可用",notes = "多学习")
    @RequestMapping("/test")
    private ResultDto test(){
        logger.info("start UserInfoController getMessageCode start,param:{}");
        //01生成随机的六位数验证码

        //02存入redis

        //03使用消息中间件消费
        return new ResultDto();
    }
}
