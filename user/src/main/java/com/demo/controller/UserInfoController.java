package com.demo.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demo.service.IUserInfoService;
import com.demo.service.IUserManageService;
import com.demo.vo.LoginVo;
import com.demo.vo.UserInfo;
import com.demo.vo.UserInfoRole;
import com.demo.vo.UserInfoRoleVo;
import constant.StatusCode;
import entity.ResultDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;


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

    @Autowired
    private IUserInfoService userInfoServiceImpl;

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


    //------------------------------------------------------
    //分页查询用户信息
    @ApiOperation(value = "用户信息分页查询",notes = "测试数据库")
    @PostMapping("/page")
    public ResultDto page(@RequestBody UserInfoRoleVo vo){
        logger.info("start UserInfoController page method");
        /**
         * 查询所有
         */
        // List<UserInfo> page = userInfoServiceImpl.list();
        //List<String> collect = page.stream().map(UserInfo::getUsername).collect(Collectors.toList());
        /**
         * 分页查
         */
        ResultDto page = userInfoServiceImpl.page(vo);

        logger.info("end UserInfoController page method,param:{}");
        return new ResultDto(StatusCode.SUCCESS,StatusCode.OPERATE_SUCCESS,page);
    }


    //分页查询用户信息
    @ApiOperation(value = "自定义分页查询",notes = "测试数据库")
    @PostMapping("/customPage")
    public ResultDto customPage(@RequestBody UserInfoRoleVo userInfoRoleReq){
        logger.info("start UserInfoController customPage method");
        Page<UserInfoRole> page = new Page<>(userInfoRoleReq.getCurrentPage(),userInfoRoleReq.getPageSize());
        List<UserInfoRole> list = userInfoServiceImpl.selectCustomPage(page,userInfoRoleReq);
        return new ResultDto(StatusCode.SUCCESS,StatusCode.OPERATE_SUCCESS,list);
    }
}
