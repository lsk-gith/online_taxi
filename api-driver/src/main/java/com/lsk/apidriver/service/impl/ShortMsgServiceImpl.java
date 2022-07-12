package com.lsk.apidriver.service.impl;

import net.sf.json.JSONObject;
import com.lsk.apidriver.service.RestTemplateRequestService;
import com.lsk.apidriver.service.ShortMsgService;
import com.lsk.common.dto.ResponseResult;
import com.lsk.common.dto.sms.SmsSendRequest;
import com.lsk.common.dto.sms.SmsTemplateDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Auther: lsk
 * @Date: 2022/7/10 - 07 - 10 - 14:36
 * @Description: com.lsk.apidriver.service.impl
 * @version: 1.0
 */
@Service
@Slf4j
public class ShortMsgServiceImpl implements ShortMsgService {

    @Autowired
    private RestTemplateRequestService restTemplateRequestService;

    @Override
    public ResponseResult send(String phoneNumber, String code) {
        System.out.println("手机号和验证码："+phoneNumber+","+code);
        String http = "http://";
        String serviceName = "SERVICE-SMS";
        String uri = "/send/alisms-template";
        String url = http + serviceName + uri;

        SmsSendRequest smsSendRequest = new SmsSendRequest();
        String[] phoneNumbers = new String[] {phoneNumber};
        smsSendRequest.setReceivers(phoneNumbers);

        List<SmsTemplateDto> data = new ArrayList<SmsTemplateDto>();
        SmsTemplateDto dto = new SmsTemplateDto();
        dto.setId("SMS_144145499");
        int templateSize = 1;
        HashMap<String, Object> templateMap = new HashMap<String, Object>(templateSize);
        templateMap.put("code", code);
        dto.setTemplateMap(templateMap);
        data.add(dto);
        smsSendRequest.setData(data);

        ResponseResult result = restTemplateRequestService.smsSend(smsSendRequest);
        System.out.println("调用短信服务返回的结果"+ JSONObject.fromObject(result));

        return result;
    }






}
