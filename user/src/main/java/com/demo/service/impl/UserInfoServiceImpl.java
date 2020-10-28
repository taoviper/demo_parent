package com.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.mapper.UserInfoMapper;
import com.demo.service.IUserInfoService;
import com.demo.utils.RandomCode;
import com.demo.vo.UserInfo;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author 9527
 * @version 1.0
 * @date 2020-10-27 10:03
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private RabbitTemplate rabbitTemplate;


    @Override
    public boolean addUserInfo(UserInfo userInfo) {
        int insert = userInfoMapper.insert(userInfo);
        return false;
    }

    @Override
    public void getMessageCode(String phone) {
        //01获取六位数随机数字
        String sixCode = RandomCode.sixCode()+"";
        //02存入redis,并设置过期时间,设置有效期为5分钟
        redisTemplate.opsForValue().set("smsCode:"+phone,sixCode+"",5, TimeUnit.MINUTES);
        //03使用消息中间件
        Map<String,String> map = new HashMap<>(16);
        map.put("phone",phone);
        map.put("code",sixCode);
        rabbitTemplate.convertAndSend("sms",map);
    }
}
