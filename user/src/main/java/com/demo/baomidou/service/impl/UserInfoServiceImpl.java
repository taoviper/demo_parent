package com.demo.baomidou.service.impl;

import com.demo.baomidou.entity.UserInfo;
import com.demo.baomidou.dao.UserInfoDao;
import com.demo.baomidou.service.UserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author taoweipu
 * @since 2020-12-21
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoDao, UserInfo> implements UserInfoService {

}
