package com.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.demo.service.IUserInfoService;
import com.demo.service.IUserManageService;
import com.demo.utils.RandomCode;
import com.demo.vo.LoginVo;
import com.demo.vo.UserInfo;
import constant.StatusCode;
import entity.ResultDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import utils.UUIDUtil;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 9527
 * @version 1.0
 * @date 2020-10-29 9:30
 */
@Service
public class UserManageServiceImpl implements IUserManageService {

    private static final Logger logger = LoggerFactory.getLogger(UserManageServiceImpl.class);

    @Autowired
    private IUserInfoService userInfoServiceImpl;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * 获取短信验证码
     * @param phone 手机号
     * @return
     */
    @Override
    @SuppressWarnings("unchecked")
    public ResultDto getMessageCode(String phone) {
        //01先校验手机号
        if(!matchPhone(phone) || phone == null ){
            return new ResultDto(StatusCode.FAIL,"手机格式不正确,请输入11位手机号");
        }
        //02查询手机号是否已存在数据库
        QueryWrapper<UserInfo> condition = new QueryWrapper<>();
        condition.eq("phone",phone);
        UserInfo one = userInfoServiceImpl.getOne(condition);
        if (one !=null){
            return new ResultDto(StatusCode.FAIL,"很抱歉,注册失败,手机号已被注册,请更换手机号");
        }
        //03生成随机六位数验证码
        String sixCode = RandomCode.sixCode();

        //04存入redis,并设置过期时间5分钟
        redisTemplate.opsForValue().set("smsCode"+phone,sixCode.trim(),5, TimeUnit.MINUTES);
        String o = (String)redisTemplate.opsForValue().get("smsCode" + phone);

        //05调用中间件发送短信
        Map<String,String> map = new HashMap<>(16);
        map.put("phone",phone);
        map.put("code",sixCode);
        rabbitTemplate.convertAndSend("sms",map);

        //06返回结果集
        return new ResultDto(StatusCode.SUCCESS,"短信已发送,请耐心等待"+"0:"+o);
    }

    /**
     * 校验登录账号
     * @param req 请求参数 登录名和密码
     * @return 结果集
     */
    @Override
    public ResultDto login(LoginVo req) {
        QueryWrapper<UserInfo> condition = new QueryWrapper<>();
        condition.eq("phone",req.getPhone());
        UserInfo one = userInfoServiceImpl.getOne(condition);
        if (bCryptPasswordEncoder.matches(req.getPassword(), one.getPassword())){
            return new ResultDto(StatusCode.SUCCESS,"登录成功");
        }else{
            return new ResultDto(StatusCode.FAIL,"密码有误,请重新输入");
        }
    }

    /**
     * 校验手机号是否符合匹配规则
     * @param phone 手机号
     * @return boo
     */
    private Boolean matchPhone(String phone){
        String regx ="^1[3456789]\\d{9}$";
        Pattern  pattern = Pattern.compile(regx);
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }


    /**
     *
     * 01根据手机号查询是否手机号已被注册
     *      若以注册,则返回提示,不予以注册
     *      若未注册,则提示可以注册.
     * @param req 实体
     * @return 结果集
     */
    @Override
    public ResultDto addUserInfo(UserInfo req) {
        //01对输入的参数做一个正则校验,暂时不做
        //02校验短信验证码
        String messageCode = req.getMessageCode();
        String cacheCode = (String) redisTemplate.opsForValue().get("smsCode" + req.getPhone());
        if (cacheCode == null){
            return new ResultDto(StatusCode.FAIL,"验证码不存在或者已过期,请重新获取");
        }
        if ( !messageCode.equals(cacheCode.trim())){
            return new ResultDto(StatusCode.FAIL,"验证码错误,请重新输入");
        }
        //03设置数据
        req.setUuid(UUIDUtil.getUUID());
        req.setDeleteMark(0);
        req.setCreateTime(new Date());

        //04对密码进行加密
        req.setPassword(bCryptPasswordEncoder.encode(req.getPassword()));

        userInfoServiceImpl.save(req);
        return new ResultDto(StatusCode.SUCCESS,"恭喜您,注册成功");
    }
}
