package com.demo.utils;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author taoweipu
 * @date 2020-9-15 10:30
 */
@Component
public class SmsUtil {

    private static final Logger logger = LoggerFactory.getLogger(SmsUtil.class);
    /**
     * @param appid  appid
     * @param appKey app key
     * @param telPhone 手机号
     * @param template 模板id
     * @param code 六位数验证码
     * @param sign 商标
     * @return
     */
    public SmsSingleSenderResult sendSms(int appid,String appKey,String telPhone,int template,String code,String sign) throws HTTPException, IOException {
        String[] param ={code};
        SmsSingleSender sender = new SmsSingleSender(appid, appKey);
//        SmsSingleSenderResult result =null;
//        try {
//            result = sender.sendWithParam("86", telPhone, template, param, sign, "", "");
//            int statusCode = result.getResponse().statusCode;
//        } catch (HTTPException | IOException e) {
//            e.printStackTrace();
//        }

        SmsSingleSenderResult result = sender.sendWithParam("86", telPhone, template, param, sign, "", "");
        //int statusCode = result.getResponse().statusCode;

        return result;
    }
}
