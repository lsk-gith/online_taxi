package com.lsk.apipassager.fallback;

import com.lsk.apipassager.feign.SmsClient;
import com.lsk.common.dto.ResponseResult;
import com.lsk.common.dto.sms.SmsSendRequest;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @Auther: lsk
 * @Date: 2022/7/14 - 07 - 14 - 20:56
 * @Description: com.lsk.apipassager.fallback
 * @version: 1.0
 */
@Component
public class SmsClientFallback implements SmsClient {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Override
    public ResponseResult sendSms(SmsSendRequest smsSendRequest) throws Exception {
        String key = "service-sms";
        String s = stringRedisTemplate.opsForValue().get(key);
        if(StringUtils.isBlank(s)){
            System.out.println("通知别人我熔断了");
            stringRedisTemplate.opsForValue().set(key, "notice", 30, TimeUnit.SECONDS);
        }else{
            System.out.println("通知过了，我先不通知了");
        }



        return ResponseResult.fail(-3, "feign熔断");
    }
}
