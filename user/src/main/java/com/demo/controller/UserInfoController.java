package com.demo.controller;

import com.demo.service.IUserManageService;
import com.demo.vo.LoginVo;
import com.demo.vo.UserInfo;
import entity.ResultDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


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
    private IUserManageService userManageServiceImpl;

    /**
     * 测试controller
     *
     */
    @ApiOperation(value = "测试swagger2是否可用",notes = "多学习")
    @GetMapping("/test")
    public ResultDto test(){
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
    public ResultDto getMessageCode(@PathVariable @ApiParam  String phone){
        logger.info("start UserInfoController getMessageCode start,param:{}",phone);
        ResultDto resultDto = userManageServiceImpl.getMessageCode(phone);
        logger.info("end getMessageCode,res:{}",resultDto);
        return resultDto;
    }

    /**
     * 注册用户
     * @param req  入参
     * @return res
     */
    @ApiOperation(value = "新增用户",notes = "测试数据库")
    @PostMapping("/register")
    public ResultDto register(@RequestBody @Valid UserInfo req){
        logger.info("start UserInfoController register method,param:{}",req);
        ResultDto resultDto  = userManageServiceImpl.addUserInfo(req);
        logger.info("end UserInfoController register method,res:{}",resultDto);
        return resultDto;
    }

    @ApiOperation(value = "用户登录",notes = "测试数据库")
    @PostMapping("/login")
    public ResultDto login(@RequestBody @Valid LoginVo req){
        logger.info("start UserInfoController login method,param:{}",req);
        ResultDto res = userManageServiceImpl.login(req);
        logger.info("end UserInfoController login method,param:{}",req);
        return res;
    }
}
