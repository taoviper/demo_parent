package com.demo.controller;

import com.demo.service.IUserInfoService;
import com.demo.vo.UserInfo;
import constant.StatusCode;
import entity.ResultDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import utils.UUIDUtil;



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

    @Autowired
    private IUserInfoService userInfoServiceImpl;

    /**
     * 获取短信验证码
     *
     */
    @ApiOperation(value = "测试swagger2是否可用",notes = "多学习")
    @RequestMapping("/test")
    private ResultDto test(){
        logger.info("start  test start,param:{}");
        System.out.println("测试");
        logger.info("end  test end");
        return new ResultDto();
    }

    /**
     * 获取短信验证码
     * @param phone 手机号
     */
    @ApiOperation(value = "获取短信验证码",notes = "多学习")
    @PostMapping("/messageCode/{phone}")
    @ResponseBody
    private ResultDto getMessageCode(@PathVariable @ApiParam  String phone){
        logger.info("start UserInfoController getMessageCode start,param:{}",phone);
        if (phone ==null){
            return new ResultDto(StatusCode.FAIL,StatusCode.PARAM_MISSING);
        }
        userInfoServiceImpl.getMessageCode(phone);



        //03使用消息中间件消费
        return new ResultDto(StatusCode.SUCCESS,StatusCode.OPERATE_SUCCESS);
    }


    /**
     * 新增用户信息
     * @param req reqParam
     * @return res
     */
    @ApiOperation(value = "新增用户",notes = "测试数据库")
    @PostMapping("/register")
    @ResponseBody
    private ResultDto addUserInfo(@RequestBody UserInfo req){
        logger.info("start UserInfoController addUserInfo method,param:{}",req);
        if (req ==null){
            return new ResultDto(StatusCode.FAIL,"参数异常",null);
        }

        req.setUuid(UUIDUtil.getUUID());
        boolean save = userInfoServiceImpl.save(req);
        if (!save){
            return new ResultDto(StatusCode.FAIL,"新增用户失败",null);
        }
        logger.info("end UserInfoController addUserInfo method,param:{}",req);
        return new ResultDto(StatusCode.SUCCESS,"新增用户成功",null);
    }
}
