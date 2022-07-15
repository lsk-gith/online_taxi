package com.lsk.apipassager.feign;

import com.lsk.apipassager.fallback.SmsClientFallback;
import com.lsk.common.dto.ResponseResult;
import com.lsk.common.dto.sms.SmsSendRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Auther: lsk
 * @Date: 2022/7/14 - 07 - 14 - 20:52
 * @Description: com.lsk.apipassager.feign
 * @version: 1.0
 */
@FeignClient(name = "service-sms",fallback = SmsClientFallback.class)
public interface SmsClient {
    /**
     * 按照短信模板发送验证码
     * @param smsSendRequest
     * @return
     */
    @RequestMapping(value="/send/alisms-template", method = RequestMethod.POST)
    public ResponseResult sendSms(@RequestBody SmsSendRequest smsSendRequest) throws Exception;
}
