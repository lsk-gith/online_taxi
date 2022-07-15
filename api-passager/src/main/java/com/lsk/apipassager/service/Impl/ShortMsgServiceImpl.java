package com.lsk.apipassager.service.Impl;

import com.lsk.apipassager.feign.SmsClient;
import com.lsk.apipassager.service.ShortMsgService;
import com.lsk.common.dto.ResponseResult;
import com.lsk.common.dto.sms.SmsSendRequest;
import com.lsk.common.dto.sms.SmsTemplateDto;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.transform.Result;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Auther: lsk
 * @Date: 2022/7/14 - 07 - 14 - 20:50
 * @Description: com.lsk.apipassager.service.Impl
 * @version: 1.0
 */
@Service
public class ShortMsgServiceImpl implements ShortMsgService {
    @Autowired
    SmsClient smsClient;



    @Override
    public ResponseResult send(String phoneNumber, String code) {
        System.out.println("手机号和验证码："+phoneNumber+","+code);
        String serviceName = "SERVICE-SMS";
        String url = "http://"+serviceName+"/send/alisms-template";
        SmsSendRequest smsSendRequest = new SmsSendRequest();
        String[] phoneNumbers = new String[] {phoneNumber};
        smsSendRequest.setReceivers(phoneNumbers);
        List<SmsTemplateDto> data = new ArrayList<>();
        SmsTemplateDto dto = new SmsTemplateDto();
        dto.setId("SMS_144145499");
        int templateSize = 1;
        HashMap<String, Object> templateMap = new HashMap<>(templateSize);
        templateMap.put("code", code);
        dto.setTemplateMap(templateMap);
        data.add(dto);
        smsSendRequest.setData(data);


//        feign 调用
        ResponseResult Result = null;
        try {
            Result = smsClient.sendSms(smsSendRequest);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("feign 异常");
        }
        System.out.println("调用短信服务返回的结果"+ JSONObject.fromObject(Result));
        return Result;
    }
}
