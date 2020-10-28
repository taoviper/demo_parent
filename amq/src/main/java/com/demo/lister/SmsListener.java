package com.demo.lister;


import com.demo.utils.SmsUtil;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

/**
 * @author taoweipu
 * @date 2020-9-15 9:54
 */
@Component
@RabbitListener(queues = "sms")
public class SmsListener {

    private static final Logger logger = LoggerFactory.getLogger(SmsListener.class);

    @Value("${appid}")
    private int appid;

    @Value("${appKey}")
    private String appKey;

    @Value("${templateId}")
    private int templateId;

    @Autowired
    private SmsUtil smsUtil;

    @RabbitHandler
    public void sendSms(Map<String,String> req){
        String sign ="带上微笑去旅行啊";
        String phone = req.get("phone");
        String code = req.get("code");
        try {
            SmsSingleSenderResult smsSingleSenderResult = smsUtil.sendSms(appid, appKey, phone, templateId, code, sign);
            int statusCode = smsSingleSenderResult.getResponse().statusCode; //200
            if (200!= statusCode){
              logger.error("发送短信状态回执异常");
            }
        } catch (HTTPException | IOException e) {
            e.printStackTrace();
            logger.error("打印日志------>>>>>>>>  message exception,param:[{}],exception:[{}]",req,e);
        }
    }
}
