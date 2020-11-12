package com.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.mapper.UserInfoMapper;
import com.demo.service.IUserInfoService;
import com.demo.vo.UserInfo;
import com.demo.vo.UserInfoRole;
import com.demo.vo.UserInfoRoleVo;

import constant.StatusCode;
import entity.ResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 9527
 * @version 1.0
 * @date 2020-10-27 10:03
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;


    /**
     * 这个mybatis-plus自带的分页组件
     *      01 创建Page对象,设置当前页和每页展示数
     *      02 编辑QueryWrapper对象,封装条件类
     *      03 基于selectPage查询分页数据展示
     * @param vo
     * @return
     */
    @Override
    public ResultDto page(UserInfoRoleVo vo) {
        Page<UserInfo> page = new Page<>(1,2);
        QueryWrapper<UserInfo> qw = new QueryWrapper<>();
        qw.eq("phone","18824606317");
        IPage<UserInfo> userInfoIPage = userInfoMapper.selectPage(page, qw);

        System.out.println("current"+userInfoIPage.getCurrent());
        System.out.println("pages"+userInfoIPage.getPages());
        System.out.println("total"+userInfoIPage.getTotal());
        System.out.println("rows"+userInfoIPage.getRecords());
        return  new ResultDto(StatusCode.SUCCESS,StatusCode.OPERATE_SUCCESS,userInfoIPage);
    }

    @Override
    public ResultDto customPage(UserInfoRoleVo vo) {
        int total = userInfoMapper.total(vo);
        int offset = vo.getOffset();
        System.out.println("total:"+total+";offset"+offset);

        return null;
    }

    @Override
    public List<UserInfoRole> selectCustomPage(Page<UserInfoRole> page, UserInfoRoleVo userInfoRoleReq) {
        List<UserInfoRole> userInfoRoles = userInfoMapper.getPage(page,userInfoRoleReq);
        return userInfoRoles;
    }
}
