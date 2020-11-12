package com.demo.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.vo.UserInfo;

import com.demo.vo.UserInfoRole;
import com.demo.vo.UserInfoRoleVo;
import entity.ResultDto;

import java.util.List;


/**
 * @author 9527
 * @version 1.0
 * @date 2020-10-27 10:01
 */
public interface IUserInfoService extends IService<UserInfo> {

    ResultDto page(UserInfoRoleVo vo);

    ResultDto customPage(UserInfoRoleVo vo);

    List<UserInfoRole> selectCustomPage(Page<UserInfoRole> page, UserInfoRoleVo vo);
}
