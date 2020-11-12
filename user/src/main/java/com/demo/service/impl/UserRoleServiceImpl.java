package com.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.mapper.UserInfoMapper;
import com.demo.mapper.UserRoleMapper;
import com.demo.service.IUserInfoService;
import com.demo.service.IUserRoleService;
import com.demo.vo.UserInfo;
import com.demo.vo.UserRole;
import org.springframework.stereotype.Service;

/**
 * @author 9527
 * @version 1.0
 * @date 2020-10-27 10:03
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {
}
